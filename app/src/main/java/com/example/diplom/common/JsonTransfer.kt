package com.example.diplom.common

import android.content.Context
import com.example.diplom.common.jsonClasses.DCBodyParts
import com.example.diplom.database.DaoSymptoms
import com.google.gson.Gson

class JsonTransfer(_ctx: Context) {
    var listSymptoms: MutableCollection<DaoSymptoms.Symptoms> =
        mutableListOf()
    private var context: Context? = _ctx
    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }

    init {
        setListBodyParts()
    }

    private fun setListBodyParts() {
        val obj: DCBodyParts =
            Gson().fromJson(getJsonString("BodyParts.json"), DCBodyParts::class.java)
        for (i in obj.arrayParts) {
            for (j in i.arraySymptoms) {
                listSymptoms.add(
                    DaoSymptoms.Symptoms(
                        j.nameSymptom,
                        i.name,
                        false
                    )
                )
            }
        }
    }


}