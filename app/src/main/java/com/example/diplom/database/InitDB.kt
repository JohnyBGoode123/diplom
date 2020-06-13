package com.example.diplom.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.App
import com.example.diplom.common.JsonTransfer
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms
import kotlinx.coroutines.launch

class InitDB: ViewModel() {
init {
    val db: AppDataBase? = App.instance?.getDatabase()
    initDB = db?.getDao()

}
    companion object {
        var initDB: DaoSymptoms? = null
    }

    fun fillBD(ctx:Context)
    {
        val jsonTransfer = JsonTransfer(ctx)
        var  tmpS: List<DaoSymptoms.Symptoms>?
        var  tmpV: List<DaoSymptoms.ValueSymptoms>?
        var tmpDandV: List<DiseaseWithVariantSymptoms>

        var tmpCrossRef: List<DaoSymptoms.VariantSymptomsCrossRef>
        viewModelScope.launch {
            try {

                initDB?.insertSymptoms(jsonTransfer.listSymptoms )
                tmpS = initDB?.getAllSymptoms()

                initDB?.insertValueSymptoms(jsonTransfer.listValueSymptoms )
                tmpV = initDB?.getAllValueSymptoms()

                initDB?.insertDisease(jsonTransfer.listDisease)
                initDB?.insertVariantSymptomsCrossRef(jsonTransfer.listVariantSymptomsCrossRef)
                initDB?.insertVariantSymptoms(jsonTransfer.listVariant)
                initDB?.insertRelevance(jsonTransfer.listRelevance)

                tmpDandV = initDB?.getDiseaseWithVariant()!!



            } catch (t: Throwable) {
                print(t.message)
            }
    }
    }
}