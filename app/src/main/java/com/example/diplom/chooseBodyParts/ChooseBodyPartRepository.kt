package com.example.diplom.chooseBodyParts

import com.example.diplom.database.relationDC.GroupWithValues

interface ChooseBodyPartRepository {

    suspend fun getBodyParts(): List<String>

    suspend fun getAllNameSymptoms(): List<String>

    suspend fun getGroupWithValues(idSymptom: Int): List<GroupWithValues>
}