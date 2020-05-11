package com.example.diplom.common.models

interface SymptomsModel {
    val nameSymptom: String
    val idBodyParts: String
    var selectionMark: Boolean
}
// android:onClick="@{(view) -> viewmodel.Swap(view, listSymptomItem,position) }"