package com.example.diplom.detailedRequest

import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.GroupWithValues


class DetailedRequestRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
): DetailedRequestRepository {
    override suspend fun getGroupWithValues(idSymptom: Int): List<GroupWithValues> {
        val tmp = daoSymptoms.getGroupWithValues(idSymptom).filter { it.group.idSymptom == idSymptom }
        return tmp
    }

    override suspend fun getTitleSymptom(idSymptom: Int): String =
       daoSymptoms.getTitleSymptoms(idSymptom)
}