package com.example.diplom.chosenSymptomsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.models.SymptomsModel
import kotlinx.coroutines.launch

class ChosenSymptomsViewModel(
    private val repository: ChosenSymptomsScreenRepository
) : ViewModel() {
    private var _listSymptoms: List<SymptomsModel>? = null
        set(value) {
            field = value
            (listSymptoms as MutableLiveData).postValue(value)
        }
    val listSymptoms: LiveData<List<SymptomsModel>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val listSymptoms: List<SymptomsModel>? = try {
                repository.getAllChosenSymptoms()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            listSymptoms?.let { _listSymptoms = it }
        }
    }

    private fun findItemByName(nameSymptom: String): SymptomsModel? {
        return _listSymptoms?.find { it.nameSymptom == nameSymptom }
    }

    fun updateSymptom(nameSymptom: String) {
        val symptom = findItemByName(nameSymptom)
        if (symptom != null) {
            symptom.selectionMark = false
        }
        viewModelScope.launch {
            try {
                if (symptom != null) {
                    repository.updateOneDeletedSymptom(symptom)
                }
            } catch (t: Throwable) {
                print(t.message)
                null
            }
        }
    }
}
