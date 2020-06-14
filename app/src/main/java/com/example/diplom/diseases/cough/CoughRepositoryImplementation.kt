package com.example.diplom.diseases.cough

import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.database.DaoSymptoms

class CoughRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
) : CoughRepository
{
    override suspend fun getValueSymptom(idSymptom: Int): List<ValueSymptomsModel> =
        daoSymptoms.getValueSymptom(idSymptom)

}