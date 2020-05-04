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
        var  tmp: List<DaoSymptoms.Symptoms>?
        viewModelScope.launch {
            try {

                initDB?.insertSymptoms(jsonTransfer.listSymptoms )
                tmp = initDB?.getAllSymptoms()


            } catch (t: Throwable) {
                print(t.message)
            }
    }
    }
}