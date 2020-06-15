package com.example.diplom.diagnosis

import com.example.diplom.common.models.DiseaseModel
import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms

class DiagnosisRepositoryImplementation(
    private val daoSymptoms: DaoSymptoms
) : DiagnosisRepository {
    override suspend fun getListDisease(): List<DiseaseWithVariantSymptoms> =
        daoSymptoms.getDiseaseWithVariant()

    override suspend fun getChosenDisease(id: Int): List<DiseaseModel> = daoSymptoms.getChosenDisease(id)
}
