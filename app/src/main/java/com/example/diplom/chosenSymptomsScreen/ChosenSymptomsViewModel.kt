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

    private var _listSymptoms: MutableList<SymptomsModel>? = null
        set(value) {
            field = value
            (listSymptoms as MutableLiveData).postValue(value)
        }
    val listSymptoms: LiveData<MutableList<SymptomsModel>> = MutableLiveData()

    private var _isEmptyList = false
        set(value) {
            field = value
            (isEmptyList as MutableLiveData).postValue(value)
        }
    val isEmptyList: LiveData<Boolean> = MutableLiveData(_isEmptyList)


    init {

        viewModelScope.launch {
            val listSymptoms: List<SymptomsModel>? = try {
                repository.getAllChosenSymptoms()

            } catch (t: Throwable) {
                print(t.message)
                null
            }
            _isEmptyList = false
            listSymptoms?.let { _listSymptoms = it as MutableList<SymptomsModel> }
        }
    }

    private fun findItemByName(nameSymptom: String): SymptomsModel? {
        return _listSymptoms?.find { it.nameSymptom == nameSymptom }
    }

    private fun deleteItmByName(symptom: SymptomsModel) {
        _listSymptoms?.let { _listSymptoms?.remove(symptom) }
    }

    fun updateSymptom(nameSymptom: String) {
        val symptom = findItemByName(nameSymptom)
        if (symptom != null) {
            deleteItmByName(symptom)
            symptom.selectionMark = false
        }
        viewModelScope.launch {
            try {
                if (symptom != null) {
                    repository.updateOneDeletedSymptom(symptom)
                }
            } catch (t: Throwable) {
                print(t.message)

            }
        }
    }

    fun setIsEmptyList()
    {
        _isEmptyList = true
    }


}
