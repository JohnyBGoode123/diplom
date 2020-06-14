package com.example.diplom.common.dagger.module

import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepository
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepositoryImplementation
import com.example.diplom.database.AppDataBase
import com.example.diplom.diseases.cough.CoughRepository
import com.example.diplom.diseases.cough.CoughRepositoryImplementation
import dagger.Module
import dagger.Provides

@Module
class CoughModule {

    @Provides
    fun coughList(
        dao: AppDataBase
    ): CoughRepository = CoughRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}