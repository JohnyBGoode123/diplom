@file:Suppress("UNUSED_VALUE")

package com.example.diplom.diagnosis


object DiagnosisAlgorithm {
 //   @JvmStatic
//    fun algorithm(listUserSymptom: List<UserSymptomModel>, listDisease: List<DiseaseWithVariantSymptoms>) {
//        /*Списки болезней и симптомов.
//          Флаг наличия симптома
//          Общее число значений в данной болезни
//          Счетчик совпадений значения
//          Объект найденного симптома.
//        */
//        var flagFindSymptom: Boolean
//        var n: Int// общее число симптомов выбранной болезни
//        var count: Int // счетчик совпадений симптомов
//        lateinit var tmpUserObject: UserSymptomModel // равен типу userListSymptoms
//        var listChosenDisease: MutableList<Int> = mutableListOf()
//        var probability: Double
//
//        // уровень болезни
//        diseaseLoop@ for (i in listDisease.indices) {
//            count = 0;
//            n = getCountValueCurrentDisease(listDisease, i)
//            flagFindSymptom = false
//            // уровень варианта симптома
//
//            for (j in listDisease[i].variant) {
//                // уровень значения
//                // ищем текущий симптом
//                try {
//                    tmpUserObject = listUserSymptom.first {
//                        it.idSymptom == j.id.idSymptom
//                    }
//                    flagFindSymptom = true
//                } catch (ex: NoSuchElementException) {
//
//                }
//                for (k in j.variants) {
//                    if (flagFindSymptom) {
//                        // Сравниваем значения
//                        if (tmpUserObject.listValueSymptom.contains(k.id)) {
//                            // они совпадают.
//                            when (k.idRelevance) {
//                                1 -> {
//                                    listChosenDisease.add(listDisease[i].disease.idDisease)
//                                    break@diseaseLoop
//                                }
//                                2 -> count++
//                                3 -> count++
//                            }
//                        } else {
//                            // они не совпадают.
//                            when (k.idRelevance) {
//                                1 -> break@diseaseLoop                // "Действие для достаточного"
//                                2 -> break@diseaseLoop             //   "Действие для необходимый"
//                            }
//                        }
//                        // симптом не найден
//                    } else {
//
//                        when (k.idRelevance) {
//                            1 -> break@diseaseLoop                // "Действие для достаточного"
//                            2 -> break@diseaseLoop             //   "Действие для необходимый"
//                        }
//                        // Ищем значеня: Достаточно и Обязательно, если находим, то швах, болезнь не идет
//                        // А как мы это сделаем? Вроде у котлина есть способ это сделать через брейк
//                    }
//
//                }
//            }
//            // проверка
//            probability = (count / n).toDouble()
//            if (probability >= 0.5) {
//                listChosenDisease.add(listDisease[i].disease.idDisease)
//            }
//        }
//    }
//
//    private fun getCountValueCurrentDisease(
//        currentDisease: List<DiseaseWithVariantSymptoms>,
//        i: Int
//    ): Int {
//        return  5
//    }

}