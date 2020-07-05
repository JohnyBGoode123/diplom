package com.example.diplom.detailedRequest

import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.GroupWithValues

interface DetailedRequestRepository {
    suspend fun getGroupWithValues(idSymptom: Int): List<GroupWithValues>

    suspend fun getTitleSymptom(idSymptom: Int): String
}