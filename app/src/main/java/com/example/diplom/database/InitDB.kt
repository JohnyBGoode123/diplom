package com.example.diplom.database

import androidx.lifecycle.ViewModel
import com.example.diplom.common.App

class InitDB: ViewModel() {
init {
initDB = App.instance?.getDatabase()?.getDao()
}
    companion object {
        var initDB: DaoSymptoms? = null
    }

    fun fillBD()
    {

    }
}