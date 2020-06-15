package com.example.diplom.diagnosis

import com.example.diplom.common.models.DiseaseModel
import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms

interface DiagnosisRepository {
    suspend fun getListDisease(): List<DiseaseWithVariantSymptoms>
    suspend fun getChosenDisease(id: Int): List<DiseaseModel>
}