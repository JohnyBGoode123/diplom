package com.example.diplom.currentSymptomsScreen

import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.database.DaoSymptoms

class CurrentSymptomsRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
) : CurrentSymptomsRepository {
    override suspend fun getSymptomsByBodyPart(bodyPart: String): List<SymptomsModel> =
        daoSymptoms.getSymptomsByBodyPart(bodyPart)


    override suspend fun updateChooseSymptoms(chosenSymptomsModel: List<SymptomsModel>) {
        TODO("Not yet implemented")
    }
}