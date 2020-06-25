package com.example.diplom.detailedInquiry

import com.example.diplom.common.models.ValueSymptomsModel

interface DetailedInquiryRepository {
    suspend fun getValueSymptom(idSymptom: Int): List<ValueSymptomsModel>
}