package com.example.diplom.common.jsonClasses

import com.example.diplom.common.models.UserSymptom

data class DCDiseases(
    val arrayDisease: List<ArrayDisease>
)

data class ArrayDisease(

    val id: Int,
    val nameDisease: String,
    val doctorCall: String,
    val recommendation: String,
    val arrayDiseaseSymptoms: List<ArrayDiseaseSymptoms>?
)

data class ArrayDiseaseSymptoms(

    val idSymptom: Int,
    val idVariant: Int,
    val idValue: Int,
    val idRelevance: Int
)



