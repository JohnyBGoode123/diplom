package com.example.diplom.common

import android.content.Context
import com.example.diplom.common.jsonClasses.DCDiseases
import com.example.diplom.common.jsonClasses.DCRelevance
import com.example.diplom.common.jsonClasses.DCSymptoms
import com.example.diplom.database.DaoSymptoms
import com.google.gson.Gson

class JsonTransfer(_ctx: Context) {
    var objSymptom: DCSymptoms
    var objDisease: DCDiseases
    var objRelevance: DCRelevance

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
    var listGroupValueSymptoms: MutableCollection<DaoSymptoms.GroupValueSymptoms> =
        mutableListOf()
    private var context: Context? = _ctx
    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }

    init {
        objSymptom = Gson().fromJson(getJsonString("Symptoms.json"), DCSymptoms::class.java)
        objDisease = Gson().fromJson(getJsonString("Disease.json"), DCDiseases::class.java)
        objRelevance = Gson().fromJson(getJsonString("Relevance.json"), DCRelevance::class.java)
        setListSymptoms()
        setListValueSymptoms()
        setListDisease()
        setDiseaseSymptomsCrossRef()
        setListRelevance()
        setListVariant()
        setGroupValueSymptoms()
    }

    private fun setListSymptoms() {

        for (i in objSymptom.arraySymptoms) {
            listSymptoms.add(
                DaoSymptoms.Symptoms(
                    i.id,
                    i.nameSymptoms,
                    i.nameBodyPart,
                    false,
                    i.title

                )
            )
        }
    }

    private fun setGroupValueSymptoms() {

        for (i in objSymptom.arraySymptoms) {
            // а если здесь симптом будет пустой, что тогда? Может быть let сделать
            i.arrayGroupValueSymptom?.let {
                for (j in it) {
                    listGroupValueSymptoms.add(
                        DaoSymptoms.GroupValueSymptoms(
                            j,
                            i.id
                        )
                    )
                }
            }
        }
    }

    private fun setListValueSymptoms() {

        for (i in objSymptom.arraySymptoms) {
            // а если здесь симптом будет пустой, что тогда? Может быть let сделать
            i.arrayValueSymptoms?.let {
                for (j in it) {
                    listValueSymptoms.add(
                        DaoSymptoms.ValueSymptoms(
                            j.id,
                            j.nameValueSymptom,
                            j.idGroup
                        )
                    )
                }
            }
        }
    }

    private fun setListDisease() {

        for (i in objDisease.arrayDisease) {
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

        for (i in objDisease.arrayDisease) {
            i.arrayDiseaseSymptoms?.let {
                for (j in it) {
                    listVariantSymptomsCrossRef.add(
                        DaoSymptoms.VariantSymptomsCrossRef(
                            i.id,
                            j.idVariant
                        )
                    )

                }
            }


        }
    }


    private fun setListRelevance() {

        for (i in objRelevance.arrayRelevance) {
            listRelevance.add(
                DaoSymptoms.Relevance(
                    i.id,
                    i.name
                )
            )
        }
    }

    private fun setListVariant() {

        for (i in objDisease.arrayDisease) {
            i.arrayDiseaseSymptoms?.let {
                for (j in it) {
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

}