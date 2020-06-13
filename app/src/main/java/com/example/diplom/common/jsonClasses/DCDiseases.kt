package com.example.diplom.common.jsonClasses

import com.example.diplom.common.models.UserSymptomModel
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms

data class DCDiseases(
    val arrayDisease: List<ArrayDisease>
)

data class ArrayDisease(

    val id: Int,
    val nameDisease: String,
    val arrayDiseaseSymptoms: List<ArrayDiseaseSymptoms>
)

data class ArrayDiseaseSymptoms(

    val idSymptom: Int,
    val idVariant: Int,
    val arrayValueSymptom: List<ArrayValueSymptom>
)

data class ArrayValueSymptom(

    val idValue: Int,
    val relevance: Int

)

//data class test(
//    var list: MutableList<DiseaseWithVariantSymptoms>
//
//
//) {
//    fun pij() {
//        var userListSymptoms: List<UserSymptomModel> = mutableListOf()
//        var flagFindSymptom: Boolean = false
//        var n: Int = 7// общее число симптомов выбранной болезни
//        var count: Int = 0 // счетчик совпадений симптомов
//        var listChosenDisease: MutableList<Int> = mutableListOf()
//        var tmp: UserSymptomModel // равен типу userListSymptoms
//
//        // уровень болезни
//        for (i in list) {
//            // уровень варианта симптома
//            for (j in i.variant) {
//                flagFindSymptom = true
//                j.id.idSymptom
//                // уровень значения
//                try {
//                    tmp = userListSymptoms.first {
//                        it.idSymptom == j.id.idSymptom
//                    }
//                } catch (ex: NoSuchElementException) {
//                    flagFindSymptom = false
//                }
//
//
//                for (k in j.playlists) {
//                    if (flagFindSymptom) {
//                        // Сравниваем значения
//                        if (tmp.listValueSymptom.contains(k.id))
//                        {
//                            // они совпадают.
//                            when (k.idRelevance)
//                            {
//                                1 -> "Действие для обязательного"
//                                2 -> "Действие для достаточного"
//                                3 -> "Действие для нейтрального"
//                            }
//                        }
//                        else
//                        {
//                            // они не совпадают.
//                            when (k.idRelevance)
//                            {
//                                1 -> "Действие для обязательного"
//                                2 -> "Действие для достаточного"
//                                3 -> "Действие для нейтрального"
//                            }
//                        }
//                    } else {
//
//                        when (k.idRelevance)
//                        {
//                            1 ->               // "Действие для достаточного"
//                            2 ->             //   "Действие для необходимого"
//                            3 ->             //   "Действие для нейтрального"
//                        }
//                        // Ищем значеня: Достаточно и Обязательно, если находим, то швах, болезнь не идет
//                        // А как мы это сделаем? Вроде у котлина есть способ это сделать через брейк
//                    }
//
//                }
//            }
//            // проверка
//            when (n) {
//                2 -> listChosenDisease.add(i.disease.idDisease)
//            }
//        }
//    }
//}
//
