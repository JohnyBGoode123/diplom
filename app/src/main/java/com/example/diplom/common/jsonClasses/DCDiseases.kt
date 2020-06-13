package com.example.diplom.common.jsonClasses

import com.example.diplom.common.models.UserSymptom

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
    val idValue: Int,
    val idRelevance: Int
)
interface NewDisease {
    val disease: Int
    val listVariant: List<NewVariant>
}

interface NewVariant {
    val id: Int
    val idSymptom: Int
    val idValue: Int
    val idRelevance: Int
}

fun algorithm(listUserSymptom: List<UserSymptom>, listDisease: List<NewDisease>) {
    /*Списки болезней и симптомов.
      Флаг наличия симптома
      Общее число значений в данной болезни
      Счетчик совпадений значения
      Объект найденного симптома.
    */
    var n: Int// общее число симптомов выбранной болезни
    var count: Int // счетчик совпадений симптомов
    lateinit var tmpUserObject: UserSymptom // равен типу userListSymptoms
    val listChosenDisease: MutableList<Int> = mutableListOf()
    var probability: Double
    diseaseLoop@ for (i in listDisease.indices) {
        count = 0;
        n = getCountValueCurrentDisease(listDisease, i)
        for (j in listDisease[i].listVariant) {
            try {
                tmpUserObject = listUserSymptom.first {
                    it.idSymptom == j.idSymptom
                }
                if (tmpUserObject.valueSymptom==j.idValue) {
                    // они совпадают.
                    when (j.idRelevance) {
                        1 -> {
                            listChosenDisease.add(listDisease[i].disease)
                            break@diseaseLoop
                        }
                        2 -> count++
                        3 -> count++
                    }
                } else {

                    when (j.idRelevance) {
                        1 -> break@diseaseLoop                // "Действие для достаточного"
                        2 -> break@diseaseLoop             //   "Действие для необходимый"
                    }
                }

            } catch (ex: NoSuchElementException) {
                when (j.idRelevance) {
                    1 -> break@diseaseLoop                // "Действие для достаточного"
                    2 -> break@diseaseLoop             //   "Действие для необходимый"
                }
            }
        }
        // проверка
        probability = (count / n).toDouble()
        if (probability >= 0.5) {
            listChosenDisease.add(listDisease[i].disease)
        }
    }
}

private fun getCountValueCurrentDisease(
    currentDisease: List<NewDisease>,
    i: Int
): Int {
    return 5
}
