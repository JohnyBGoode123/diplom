package com.example.diplom.diagnosis

import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms

interface DiagnosisRepository {
    suspend fun getListDisease(): List<DiseaseWithVariantSymptoms>
}