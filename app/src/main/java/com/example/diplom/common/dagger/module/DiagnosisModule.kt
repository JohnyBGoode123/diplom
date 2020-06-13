package com.example.diplom.common.dagger.module

import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepository
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepositoryImplementation
import com.example.diplom.database.AppDataBase
import com.example.diplom.diagnosis.DiagnosisRepository
import com.example.diplom.diagnosis.DiagnosisRepositoryImplementation
import dagger.Module
import dagger.Provides

@Module
class DiagnosisModule {
    @Provides
    fun diagnosis(
        dao: AppDataBase
    ): DiagnosisRepository = DiagnosisRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}