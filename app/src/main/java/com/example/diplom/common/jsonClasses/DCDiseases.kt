package com.example.diplom.common.jsonClasses

data class DCDiseases (
    val arrayDisease : List<ArrayDisease>
)
data class ArrayDisease (

    val id : Int,
    val nameDisease : String,
    val arrayDiseaseSymptoms : List<ArrayDiseaseSymptoms>
)

data class ArrayDiseaseSymptoms (

    val idGroup: Int,
    val idSymptom : Int,
    val arrayValueSymptom : List<ArrayValueSymptom>
)

data class ArrayValueSymptom (

    val idValue : Int,
    val relevance : Int
)
