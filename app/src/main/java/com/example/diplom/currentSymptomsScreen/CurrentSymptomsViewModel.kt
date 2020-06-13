package com.example.diplom.currentSymptomsScreen

import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.models.SymptomsModel
import kotlinx.coroutines.launch

class CurrentSymptomsViewModel(
    private val nameBodyPart: String,
    private val repository: CurrentSymptomsRepository
) : ViewModel() {
   private  var _listSymptoms: List<SymptomsModel>? = null
        set(value) {
            field = value
            (listSymptoms as MutableLiveData).postValue(value)
        }
     val listSymptoms: LiveData<List<SymptomsModel>> = MutableLiveData()
    init {
        viewModelScope.launch {
            val listSymptoms: List<SymptomsModel>? = try{
                repository.getSymptomsByBodyPart(nameBodyPart)
            } catch (t: Throwable){
                print(t.message)
                null
            }
            listSymptoms?.let { _listSymptoms = it}
        }
    }
    fun updateSymptoms()
    {
        viewModelScope.launch {
           try{
               repository.updateChooseSymptoms(_listSymptoms)
           } catch (t: Throwable){
                print(t.message)
                null
            }
        }
    }
}