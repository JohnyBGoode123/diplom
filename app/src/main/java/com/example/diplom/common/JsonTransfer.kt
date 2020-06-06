package com.example.diplom.common

import android.content.Context
import com.example.diplom.common.jsonClasses.DCDiseases
import com.example.diplom.common.jsonClasses.DCRelevance
import com.example.diplom.common.jsonClasses.DCSymptoms
import com.example.diplom.database.DaoSymptoms
import com.google.gson.Gson

class JsonTransfer(_ctx: Context) {
    var listSymptoms: MutableCollection<DaoSymptoms.Symptoms> =
        mutableListOf()
    var listValueSymptoms: MutableCollection<DaoSymptoms.ValueSymptoms> =
        mutableListOf()
    var listDisease: MutableCollection<DaoSymptoms.Disease> =
        mutableListOf()
    var listGroupValueSymptomsByDisease: MutableCollection<DaoSymptoms.GroupValueSymptomsByDisease> =
        mutableListOf()
    var listDirectoryValueSymptoms: MutableCollection<DaoSymptoms.DirectoryValueSymptoms> =
        mutableListOf()
    var listRelevance: MutableCollection<DaoSymptoms.Relevance> =
        mutableListOf()
    private var context: Context? = _ctx
    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }

    init {
        setListSymptoms()
        setListValueSymptoms()
        setListDisease()
        setGroupValueSymptomsByDisease()
        setDirectoryValueSymptoms()
        setListRelevance()
    }

    private fun setListSymptoms() {
        val obj: DCSymptoms =
            Gson().fromJson(getJsonString("Symptoms.json"), DCSymptoms::class.java)
        for (i in obj.arraySymptoms) {
            listSymptoms.add(
                DaoSymptoms.Symptoms(
                    i.id,
                    i.nameSymptoms,
                    i.nameBodyPart,
                    false
                )
            )
        }
    }

    private fun setListValueSymptoms() {
        val obj: DCSymptoms =
            Gson().fromJson(getJsonString("Symptoms.json"), DCSymptoms::class.java)
        for (i in obj.arraySymptoms) {
            for (j in i.arrayValueSymptoms) {
                listValueSymptoms.add(
                    DaoSymptoms.ValueSymptoms(
                        j.id,
                        j.nameValueSymptom,
                        i.id
                    )
                )
            }
        }
    }

    private fun setListDisease() {
        val obj: DCDiseases =
            Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        for (i in obj.arrayDisease) {
            listDisease.add(
                DaoSymptoms.Disease(
                    i.id,
                    i.nameDisease,
                    1
                )
            )
        }
    }

    private fun setGroupValueSymptomsByDisease() {
        val obj: DCDiseases =
            Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        for (i in obj.arrayDisease) {
            for (j in i.arrayDiseaseSymptoms) {
                listGroupValueSymptomsByDisease.add(
                    DaoSymptoms.GroupValueSymptomsByDisease(
                        j.idGroup,
                        j.idSymptom,
                        i.id
                    )
                )
            }

        }
    }

    private fun setDirectoryValueSymptoms() {
        val obj: DCDiseases =
            Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        for (i in obj.arrayDisease) {
            for (j in i.arrayDiseaseSymptoms) {
                for (k in j.arrayValueSymptom) {
                    listDirectoryValueSymptoms.add(
                        DaoSymptoms.DirectoryValueSymptoms(
                            k.idValue,
                            j.idSymptom,
                            k.relevance
                        )
                    )
                }

            }

        }
    }

    private fun setListRelevance() {
        val obj: DCRelevance =
            Gson().fromJson(getJsonString("Relevance.json"), DCRelevance::class.java)
        for (i in obj.arrayRelevance) {
            listRelevance.add(
                DaoSymptoms.Relevance(
                  i.id,
                    i.name
                )
            )
        }
    }

}