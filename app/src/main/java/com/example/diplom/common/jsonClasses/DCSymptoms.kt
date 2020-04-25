package com.example.diplom.common.jsonClasses

data class DCSymptoms(

    var arraySymptoms: Array<tmpSymptoms>
)

data class tmpSymptoms(
    var name: String,
    var idBodyParts: String
)
