package com.example.diplom.common.dagger.module

import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepository
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsRepositoryImplementation
import com.example.diplom.database.AppDataBase
import dagger.Module
import dagger.Provides

@Module
class CurrentSymptomsModule {

    @Provides
    fun dietList(
        dao: AppDataBase
    ): CurrentSymptomsRepository = CurrentSymptomsRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}