package com.example.diplom.chooseBodyParts

interface ChooseBodyPartRepository {

    suspend fun getBodyParts(): List<String>
}