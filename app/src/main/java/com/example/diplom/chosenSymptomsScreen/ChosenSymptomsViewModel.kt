package com.example.diplom.chosenSymptomsScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.models.SymptomsModel
import kotlinx.coroutines.launch

class ChosenSymptomsViewModel(
    private val repository: ChosenSymptomsScreenRepository
): ViewModel() {
    var _listSymptoms: List<SymptomsModel>? = null
        set(value) {
            field = value
            listSymptoms.postValue(value)
        }
    var listSymptoms: MutableLiveData<List<SymptomsModel>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val listSymptoms: List<SymptomsModel>? = try{
                repository.getAllChosenSymptoms()
            } catch (t: Throwable){
                print(t.message)
                null
            }
            listSymptoms?.let { _listSymptoms = it}
        }
    }
    fun updateSymptom(symptom: SymptomsModel)
    {
        viewModelScope.launch {
            try{
                repository.updateOneDeletedSymptom(symptom)
            } catch (t: Throwable){
                print(t.message)
                null
            }
        }
    }
}
