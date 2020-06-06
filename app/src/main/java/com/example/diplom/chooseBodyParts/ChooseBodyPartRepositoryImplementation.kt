package com.example.diplom.chooseBodyParts

import com.example.diplom.database.DaoSymptoms

class ChooseBodyPartRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
) : ChooseBodyPartRepository {
    override suspend fun getBodyParts(): List<String> = daoSymptoms.getBodyParts()
    override suspend fun getAllNameSymptoms(): List<String> = daoSymptoms.getNameSymptoms()


}