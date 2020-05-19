package com.example.diplom.chosenSymptomsScreen

import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.database.DaoSymptoms

class ChosenSymptomsScreenRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
): ChosenSymptomsScreenRepository {
    override suspend fun getAllChosenSymptoms(): List<SymptomsModel> {
        return daoSymptoms.getAllChosenSymptoms()
    }

    override suspend fun updateOneDeletedSymptom(symptom: SymptomsModel) {
        daoSymptoms.updateOneDeletedSymptom(symptom as DaoSymptoms.Symptoms)
    }

    override suspend fun getIdScreenChosenSymptoms(): List<String> {
       return daoSymptoms.getIdScreenChosenSymptoms()
    }
}