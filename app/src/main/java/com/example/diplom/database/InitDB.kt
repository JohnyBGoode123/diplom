package com.example.diplom.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.JsonTransfer
import kotlinx.coroutines.launch

class InitDB(
    val daoSymptoms: DaoSymptoms,
    val jsonTransfer: JsonTransfer
) : ViewModel() {
    init {
        if(checkDB()>0)
        {
            setInitState()
        }
        else
        {
            fillBD()
        }


    }

    private fun setInitState() {
        viewModelScope.launch {
            try {
               daoSymptoms.setSymptomSmFalse()
            } catch (t: Throwable) {
                print(t.message)
            }
        }
    }
    private fun checkDB(): Int
    {
        var result = 0
        viewModelScope.launch {
            val tmp: Int = try {
                daoSymptoms.getCountLinesSymptoms()
            } catch (t: Throwable) {
                print(t.message)
               -1
            }
            result = tmp

        }
        return result

    }

    private fun fillBD() {
        viewModelScope.launch {
            try {
                daoSymptoms.insertSymptoms(jsonTransfer.listSymptoms)
                daoSymptoms.insertValueSymptoms(jsonTransfer.listValueSymptoms)
                daoSymptoms.insertDisease(jsonTransfer.listDisease)
                daoSymptoms.insertVariantSymptomsCrossRef(jsonTransfer.listVariantSymptomsCrossRef)
                daoSymptoms.insertVariantSymptoms(jsonTransfer.listVariant)
                daoSymptoms.insertRelevance(jsonTransfer.listRelevance)
                daoSymptoms.insertGroupValueSymptoms(jsonTransfer.listGroupValueSymptoms)
            } catch (t: Throwable) {
                print(t.message)
            }
        }
    }
}