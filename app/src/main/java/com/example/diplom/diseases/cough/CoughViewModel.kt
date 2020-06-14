package com.example.diplom.diseases.cough

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.ScreenRoute
import com.example.diplom.common.UserSymptoms
import com.example.diplom.common.models.ValueSymptomsModel
import kotlinx.coroutines.launch

class CoughViewModel(
    private val idSymptom: Int,
    private val repository: CoughRepository
) : ViewModel() {
    private var _listValue: List<ValueSymptomsModel>? = null
        set(value) {
            field = value
            (listValue as MutableLiveData).postValue(value)
        }
    val listValue: LiveData<List<ValueSymptomsModel>> = MutableLiveData()
    init {
        viewModelScope.launch {
            val listValue: List<ValueSymptomsModel>? = try {
                repository.getValueSymptom(idSymptom)
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            listValue?.let { _listValue = it

            }
        }
    }



    fun buttonClick(text: String) {
       val tmp = _listValue?.first { it.nameValue == text }
       tmp?.let {
           UserSymptoms.addUserSymptom(it.idSymptoms,it.id)
       }
        ScreenRoute.nextScreen()
    }






}