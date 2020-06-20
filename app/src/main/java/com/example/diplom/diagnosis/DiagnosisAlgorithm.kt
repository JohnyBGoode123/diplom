@file:Suppress("UNUSED_VALUE")

package com.example.diplom.diagnosis


import com.example.diplom.common.models.UserSymptom
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms


object DiagnosisAlgorithm {
    @JvmStatic
    fun algorithm(
        listUserSymptom: List<UserSymptom>,
        listDisease: List<DiseaseWithVariantSymptoms>
    ): Int {

        var n: Int// общее число симптомов выбранной болезни
        var count: Int // счетчик совпадений симптомов
        lateinit var tmpUserObject: UserSymptom
        var probability: Double
        var maxProbability = 0.0
        var resultId = 0 // текущая выбранная болезнь
        diseaseLoop@ for (i in listDisease) {
            count = 0;
            n = i.variant.size
            for (j in i.variant) {
                try {
                    tmpUserObject = listUserSymptom.first {
                        it.idSymptom == j.idSymptom
                    }
                    if (tmpUserObject.valueSymptom == j.idValue) {
                        when (j.idRelevance) {
                            1 -> {
                                return i.disease.idDisease
                            }
                            2 -> count++
                            3 -> count++
                        }
                    } else {

                        when (j.idRelevance) {
                            1 -> continue@diseaseLoop                // "Действие для достаточного"
                            2 -> continue@diseaseLoop             //   "Действие для необходимый"
                        }
                    }

                } catch (ex: NoSuchElementException) {
                    when (j.idRelevance) {
                        1 -> continue@diseaseLoop                // "Действие для достаточного"
                        2 -> continue@diseaseLoop             //   "Действие для необходимый"
                    }
                }
            }
            probability = try {
                (count / n).toDouble()
            } catch (ex: Exception) {
                0.0
            }
            if (probability >= 0.5 && probability > maxProbability) {
                maxProbability = probability
                resultId = i.disease.idDisease

            }
        }
        return resultId
    }


}