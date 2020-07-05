package com.example.diplom.chooseBodyParts

import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.GroupWithValues

class ChooseBodyPartRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
) : ChooseBodyPartRepository {
    override suspend fun getBodyParts(): List<String> = daoSymptoms.getBodyParts()
    override suspend fun getAllNameSymptoms(): List<String> = daoSymptoms.getNameSymptoms()
    override suspend fun getGroupWithValues(idSymptom: Int): List<GroupWithValues> =
        daoSymptoms.getGroupWithValues(idSymptom)
}