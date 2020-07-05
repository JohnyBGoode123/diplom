package com.example.diplom.common

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.diplom.common.dagger.component.CurrentSymptomsComponent
import com.example.diplom.common.dagger.component.DaggerCurrentSymptomsComponent
import com.example.diplom.common.dagger.module.*
import com.example.diplom.database.AppDataBase
import com.example.diplom.database.InitDB
import javax.inject.Inject

class App : Application() {
    lateinit var initDB: InitDB
    private var database: AppDataBase? = null
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
            .chosenSymptomsScreenModule(ChosenSymptomsScreenModule())
            .chooseBodyPartModule(ChooseBodyPartModule())
            .diagnosisModule(DiagnosisModule())
            .detailedRequestModule(DetailedRequestModule())
            .initDBModule(InitDBModule())
            .jsonModule(JsonModule())
            .build()
        initDB = repositories.getInitDB()


    }

    companion object {
        lateinit var repositories: CurrentSymptomsComponent
            private set
        lateinit var instance: App
    }

    fun getDatabase(): AppDataBase? = database
    fun getContext(): Context {
        return applicationContext
    }
}