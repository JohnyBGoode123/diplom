package com.example.diplom.common.dagger.module

import com.example.diplom.chooseBodyParts.ChooseBodyPartRepository
import com.example.diplom.chooseBodyParts.ChooseBodyPartRepositoryImplementation
import com.example.diplom.chosenSymptomsScreen.ChosenSymptomsScreenRepository
import com.example.diplom.chosenSymptomsScreen.ChosenSymptomsScreenRepositoryImplementation
import com.example.diplom.database.AppDataBase
import dagger.Module
import dagger.Provides

@Module
class ChooseBodyPartModule {
    @Provides
    fun bodyPartList(
        dao: AppDataBase
    ): ChooseBodyPartRepository = ChooseBodyPartRepositoryImplementation(
        daoSymptoms = dao.getDao()
    )
}