package com.example.diplom.common

import android.app.Application
import androidx.room.Room
import com.example.diplom.common.dagger.component.CurrentSymptomsComponent
import com.example.diplom.common.dagger.component.DaggerCurrentSymptomsComponent
import com.example.diplom.common.dagger.module.CurrentSymptomsModule
import com.example.diplom.database.AppDataBase
import com.example.diplom.database.InitDB

class App: Application() {
    private lateinit var initDB: InitDB
    private var database:  AppDataBase? = null
    override fun onCreate() {
        super.onCreate()
      instance = this
      database = Room.databaseBuilder(this, AppDataBase::class.java, "database")
          .fallbackToDestructiveMigration()
          .build()
        repositories = DaggerCurrentSymptomsComponent
            .builder()
            .appDataBase(database)
            .currentSymptomsModule(CurrentSymptomsModule())
            .build()
        initDB = InitDB()
        initDB.fillBD(applicationContext)

    }

    companion object {
        lateinit var repositories: CurrentSymptomsComponent
            private set
        var instance: App? = null
    }
     fun getDatabase(): AppDataBase? =  database

}