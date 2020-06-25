package com.example.diplom.common.models

interface SymptomsModel {
    val id: Int
    val nameSymptom: String
    val bodyParts: String
    var selectionMark: Boolean
    val title: String?
}
