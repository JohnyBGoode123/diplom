package com.example.diplom.common.dagger.module

import com.example.diplom.chosenSymptomsScreen.ChosenSymptomsScreenRepository
import com.example.diplom.chosenSymptomsScreen.ChosenSymptomsScreenRepositoryImplementation
import com.example.diplom.database.AppDataBase
import dagger.Module
import dagger.Provides
@Module
class ChosenSymptomsScreenModule {
    @Provides
    fun chosenSymptomsList(
        dao: AppDataBase
    ): ChosenSymptomsScreenRepository = ChosenSymptomsScreenRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}