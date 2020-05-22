package com.example.diplom.chooseBodyParts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ChooseBodyPartViewModel(
    private val repository: ChooseBodyPartRepository,
    val navigator: ChooseBodyPartClickButtonInterface
) : ViewModel() {
    var _listBodyParts: List<String>? = null
        set(value) {
            field = value
            listBodyParts.postValue(value)
        }
    val listBodyParts: MutableLiveData<List<String>> = MutableLiveData()

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
    fun buttonClick(text: String)
    {
        navigator.clickButton(text)
    }

}