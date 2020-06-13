package com.example.diplom.common

import com.example.diplom.common.models.UserSymptom

object UserSymptoms {
   private val listUserSymptom: MutableList<UserSymptom> =  mutableListOf()
    @JvmStatic
    fun addUserSymptom(idSymptom: Int, idValue: Int? = null)
    {
        listUserSymptom.add(UserSymptom(idSymptom,idValue))
    }

}