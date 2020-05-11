package com.example.diplom.currentSymptomsScreen

import com.example.diplom.common.models.SymptomsModel

interface CurrentSymptomsRepository {

    suspend fun getSymptomsByBodyPart(bodyPart: String): List<SymptomsModel>

    suspend fun updateChooseSymptoms(chosenSymptomsModel: List<SymptomsModel>?)
}