package com.example.diplom.common

import android.app.Application
import androidx.room.Room
import com.example.diplom.database.AppDataBase
import com.example.diplom.database.InitDB

class App: Application() {
    private var initDB: InitDB? = null
    private var database:  AppDataBase? = null
    override fun onCreate() {
        super.onCreate()
      instance = this
      database = Room.databaseBuilder(this, AppDataBase::class.java, "database")
          .fallbackToDestructiveMigration()
          .build()
    }
    companion object {
       // lateinit var repositories: RepositoryComponent
        //    private set
        var instance: App? = null
    }
     fun getDatabase(): AppDataBase? =  database

}