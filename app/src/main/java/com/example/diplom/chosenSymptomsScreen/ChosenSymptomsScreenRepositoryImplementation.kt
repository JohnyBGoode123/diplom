package com.example.diplom.chosenSymptomsScreen

import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.database.DaoSymptoms

class ChosenSymptomsScreenRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
): ChosenSymptomsScreenRepository {
    override suspend fun getAllChosenSymptoms(): List<SymptomsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun updateOneDeletedSymptom(symptom: SymptomsModel) {
        TODO("Not yet implemented")
    }
}