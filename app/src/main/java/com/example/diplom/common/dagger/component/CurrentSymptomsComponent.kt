package com.example.diplom.common.dagger.component

import com.example.diplom.common.dagger.module.CurrentSymptomsModule
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepository
import com.example.diplom.database.AppDataBase
import dagger.Component
@Component(

    dependencies = [AppDataBase::class],
    modules = [CurrentSymptomsModule::class]
)
    abstract class CurrentSymptomsComponent
    {
        abstract fun currentSymptoms(): CurrentSymptomsRepository
    }
