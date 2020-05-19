package com.example.diplom.common.jsonClasses

data class DCBodyParts(
    var arrayParts: Array<tmpBodyParts>
)
data class tmpBodyParts
    (
    var name: String,
    var arraySymptoms: Array<tmpSymptoms>

)
data class tmpSymptoms(
    var nameSymptom: String
)
