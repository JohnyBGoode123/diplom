package com.example.diplom.detailedInquiry

import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.database.DaoSymptoms

class DetailedInquiryRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
) : DetailedInquiryRepository
{
    override suspend fun getValueSymptom(idSymptom: Int): List<ValueSymptomsModel> =
        daoSymptoms.getValueSymptom(idSymptom)

}