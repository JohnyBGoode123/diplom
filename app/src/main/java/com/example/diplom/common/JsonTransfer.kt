package com.example.diplom.common

import android.content.Context
import com.example.diplom.common.jsonClasses.DCBodyParts
import com.example.diplom.common.jsonClasses.DCSymptoms
import com.example.diplom.database.DaoSymptoms
import com.google.gson.Gson

class JsonTransfer(_ctx: Context) {
    var listBodyParts: MutableCollection<DaoSymptoms.BodyParts>? =
        mutableListOf()
    var listSymptoms: MutableCollection<DaoSymptoms.Symptoms>? =
        mutableListOf()
    private var context: Context? = _ctx
    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }

    init {
        setListBodyParts()
        setListSymptoms()
    }

    private fun setListBodyParts() {
        val obj: DCBodyParts =
            Gson().fromJson(getJsonString("BodyParts.json"), DCBodyParts::class.java)
        for (i in obj.arrayParts) {
            listBodyParts?.add(
                DaoSymptoms.BodyParts(
                    i.name
                )
            )
        }
    }
    private fun setListSymptoms() {
        val obj: DCSymptoms =
            Gson().fromJson(getJsonString("Symptoms.json"), DCSymptoms::class.java)
        for (i in obj.arraySymptoms) {
            listSymptoms?.add(
                DaoSymptoms.Symptoms(
                    i.name,
                    i.idBodyParts,
                    false
                )
            )
        }
    }


}