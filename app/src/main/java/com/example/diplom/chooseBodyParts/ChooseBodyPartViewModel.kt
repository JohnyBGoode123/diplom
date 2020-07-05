package com.example.diplom.chooseBodyParts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.ListsSymptoms
import kotlinx.coroutines.launch


class

ChooseBodyPartViewModel(
    private val repository: ChooseBodyPartRepository,
    val navigator: ChooseBodyPartClickButtonInterface
) : ViewModel() {
    var _listBodyParts: List<String>? = null
        set(value) {
            field = value
            (listBodyParts as MutableLiveData).postValue(value)
        }
    val listBodyParts: LiveData<List<String>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val listBodyParts: List<String>? = try {
                repository.getBodyParts()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            listBodyParts?.let { _listBodyParts = it }
        }
    }
    init {
        viewModelScope.launch {
            val listAllNameSymptoms: List<String>? = try {
                repository.getAllNameSymptoms()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            listAllNameSymptoms?.let { ListsSymptoms.listAllSymptoms = it }
        }
    }
    fun buttonClick(text: String)
    {
        navigator.clickButton(text)
    }

}