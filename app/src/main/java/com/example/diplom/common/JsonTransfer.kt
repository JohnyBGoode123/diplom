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
    var listVariantSymptomsCrossRef: MutableCollection<DaoSymptoms.VariantSymptomsCrossRef> =
        mutableListOf()
    var listRelevance: MutableCollection<DaoSymptoms.Relevance> =
        mutableListOf()
    var listVariant: MutableCollection<DaoSymptoms.VariantSymptoms> =
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
        setDiseaseSymptomsCrossRef()
        setListRelevance()
        setListVariant()
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
            // а если здесь симптом будет пустой, что тогда? Может быть let сделать
            i.arrayValueSymptoms?.let {
                for (j in it) {
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
    }

    private fun setListDisease() {
        val obj: DCDiseases =
            Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        for (i in obj.arrayDisease) {
            listDisease.add(
                DaoSymptoms.Disease(
                    i.id,
                    i.nameDisease,
                    i.doctorCall,
                    i.recommendation
                )
            )
        }
    }

    private fun setDiseaseSymptomsCrossRef() {
        val obj: DCDiseases =
            Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        for (i in obj.arrayDisease) {
            for (j in i.arrayDiseaseSymptoms) {
                listVariantSymptomsCrossRef.add(
                    DaoSymptoms.VariantSymptomsCrossRef(
                        i.id,
                        j.idVariant
                    )
                )

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

    private fun setListVariant() {
        val obj: DCDiseases =
            Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        for (i in obj.arrayDisease) {
            for (j in i.arrayDiseaseSymptoms) {
                listVariant.add(
                    DaoSymptoms.VariantSymptoms(
                        j.idVariant,
                        j.idSymptom,
                        j.idValue,
                        j.idRelevance
                    )
                )
            }
        }
    }

}