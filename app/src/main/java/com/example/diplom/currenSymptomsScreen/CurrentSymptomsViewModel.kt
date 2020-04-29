package com.example.diplom.currenSymptomsScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.models.SymptomsModel
import kotlinx.coroutines.launch

class CurrentSymptomsViewModel(
    private val nameBodyPart: String,
    private val repository: CurrentSymptomsRepository
) : ViewModel() {
    private var _listSymptoms: List<SymptomsModel>? = null
        set(value) {
            field = value
            listSymptoms.postValue(value)
        }
    private val listSymptoms: MutableLiveData<List<SymptomsModel>> = MutableLiveData()


    init {
        viewModelScope.launch {
            val listSymptoms: List<SymptomsModel>? = try{
                repository.getSymptomsByBodyPart(nameBodyPart)
            } catch (t: Throwable){
                print(t.message)
                null
            }
            listSymptoms?.let {_listSymptoms = it}
        }
    }
}