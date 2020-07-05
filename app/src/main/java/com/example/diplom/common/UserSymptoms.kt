package com.example.diplom.common

import com.example.diplom.common.models.UserSymptom

object UserSymptoms {
    var listUserSymptom: MutableList<UserSymptom> =  mutableListOf()
    private set
    @JvmStatic
    fun removeListUserSymptom()
    {
        listUserSymptom.removeAll(listUserSymptom)
    }
    @JvmStatic
    fun addUserSymptom(idSymptom: Int, idValue: Int = 0)
    {
        listUserSymptom.add(UserSymptom(idSymptom,idValue))
    }
    @JvmStatic
    fun getUserSymptomList(): MutableList<UserSymptom> = listUserSymptom


}