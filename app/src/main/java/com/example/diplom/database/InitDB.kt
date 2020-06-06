package com.example.diplom.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.App
import com.example.diplom.common.JsonTransfer
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
        viewModelScope.launch {
            try {

                initDB?.insertSymptoms(jsonTransfer.listSymptoms )
                tmpS = initDB?.getAllSymptoms()

                initDB?.insertValueSymptoms(jsonTransfer.listValueSymptoms )
                tmpV = initDB?.getAllValueSymptoms()


            } catch (t: Throwable) {
                print(t.message)
            }
    }
    }
}