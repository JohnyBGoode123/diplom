package com.example.diplom.currentSymptomsScreen

import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.models.SymptomsModel
import kotlinx.coroutines.launch
import java.text.FieldPosition

class CurrentSymptomsViewModel(
    private val nameBodyPart: String,
    private val repository: CurrentSymptomsRepository
) : ViewModel() {
     var _listSymptoms: List<SymptomsModel>? = null
        set(value) {
            field = value
            listSymptoms.postValue(value)
        }
     val listSymptoms: MutableLiveData<List<SymptomsModel>> = MutableLiveData()


fun Swap(view: View, item: SymptomsModel, position: Int)
{
    val currentCheckBox = view as CheckBox
    var qwe = item.selectionMark
    qwe = currentCheckBox.isChecked
    listSymptoms.let{ _listSymptoms?.get(position)?.selectionMark = qwe }
}

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