package com.example.diplom.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.App
import com.example.diplom.common.JsonTransfer
import kotlinx.coroutines.launch

class InitDB : ViewModel() {
    init {
        val db: AppDataBase? = App.instance?.getDatabase()
        initDB = db?.getDao()

    }

    companion object {
        var initDB: DaoSymptoms? = null
    }

    fun fillBD(ctx: Context) {
        val jsonTransfer = JsonTransfer(ctx)
        viewModelScope.launch {
            try {

                initDB?.insertSymptoms(jsonTransfer.listSymptoms)


                initDB?.insertValueSymptoms(jsonTransfer.listValueSymptoms)


                initDB?.insertDisease(jsonTransfer.listDisease)
                initDB?.insertVariantSymptomsCrossRef(jsonTransfer.listVariantSymptomsCrossRef)
                initDB?.insertVariantSymptoms(jsonTransfer.listVariant)
                initDB?.insertRelevance(jsonTransfer.listRelevance)


            } catch (t: Throwable) {
                print(t.message)
            }
        }
    }
}