package com.example.diplom.diseases.cough

import com.example.diplom.common.models.ValueSymptomsModel

interface CoughRepository {
    suspend fun getValueSymptom(idSymptom: Int): List<ValueSymptomsModel>
}