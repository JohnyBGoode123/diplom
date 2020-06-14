package com.example.diplom.common.dagger.component

import com.example.diplom.chooseBodyParts.ChooseBodyPartRepository
import com.example.diplom.chosenSymptomsScreen.ChosenSymptomsScreenRepository
import com.example.diplom.common.dagger.module.*
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepository
import com.example.diplom.database.AppDataBase
import com.example.diplom.diagnosis.DiagnosisRepository
import com.example.diplom.diseases.cough.CoughRepository
import dagger.Component
@Component(

    dependencies = [AppDataBase::class],
    modules = [CurrentSymptomsModule::class,
    ChosenSymptomsScreenModule::class,
    ChooseBodyPartModule::class,
    DiagnosisModule::class,
    CoughModule::class]
)
    abstract class CurrentSymptomsComponent
    {
        abstract fun currentSymptoms(): CurrentSymptomsRepository

        abstract fun chosenSymptoms(): ChosenSymptomsScreenRepository

        abstract fun chosenBodyParts(): ChooseBodyPartRepository

        abstract fun diagnosis(): DiagnosisRepository

        abstract fun cough(): CoughRepository
    }
