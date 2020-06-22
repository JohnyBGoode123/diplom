package com.example.diplom.diseases.cough

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.ScreenRoute
import com.example.diplom.common.UserSymptoms
import com.example.diplom.common.models.ValueSymptomsModel
import kotlinx.coroutines.launch
import java.text.FieldPosition

class CoughViewModel(
    private val idSymptom: Int,
    private val repository: CoughRepository
) : ViewModel() {
    var tmpArrayBoolean = emptyArray<Boolean>()
        private var _listValue: List<ValueSymptomsModel>? = null
        set(value) {
            field = value
            (listValue as MutableLiveData).postValue(value)
        }
    val listValue: LiveData<List<ValueSymptomsModel>> = MutableLiveData()

    private var _arrayChecked = emptyArray<Boolean>()
    set(value) {
        field = value
        (arrayChecked as MutableLiveData).postValue(value)
    }
    val arrayChecked: LiveData<Array<Boolean>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val listValue: List<ValueSymptomsModel>? = try {
                repository.getValueSymptom(idSymptom)
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            listValue?.let {
                _listValue = it
                for(i in it)
                {
                    tmpArrayBoolean += false
                }
                _arrayChecked = tmpArrayBoolean
            }
        }
    }


    fun radioButtonClick(position: Int)
    {
        tmpArrayBoolean[position] = true
        for (i in tmpArrayBoolean.indices)
        {
            if(i != position)
            {
                tmpArrayBoolean[i] = false
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