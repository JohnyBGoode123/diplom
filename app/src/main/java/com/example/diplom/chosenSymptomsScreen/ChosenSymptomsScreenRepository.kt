package com.example.diplom.chosenSymptomsScreen

import com.example.diplom.common.models.SymptomsModel


interface ChosenSymptomsScreenRepository {
    suspend fun getAllChosenSymptoms(): List<SymptomsModel>
    suspend fun updateOneDeletedSymptom(symptom: SymptomsModel)
    suspend fun getIdScreenChosenSymptoms(): List<Int>
}