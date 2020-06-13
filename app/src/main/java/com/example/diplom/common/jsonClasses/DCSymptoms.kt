package com.example.diplom.common.jsonClasses

data class DCSymptoms (

    val arraySymptoms : List<ArraySymptoms>
)
data class ArraySymptoms (
    val id : Int,
    val nameSymptoms : String,
    val nameBodyPart : String,
    val arrayValueSymptoms : List<ArrayValueSymptoms>?
)
data class ArrayValueSymptoms (

    val id : Int,
    val nameValueSymptom : String
)