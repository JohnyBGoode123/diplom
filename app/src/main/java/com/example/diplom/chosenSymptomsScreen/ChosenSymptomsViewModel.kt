package com.example.diplom.chosenSymptomsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.Constants
import com.example.diplom.common.ScreenRoute
import com.example.diplom.common.UserSymptoms
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.common.models.UserSymptom
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
            listSymptoms?.let {
                _listSymptoms = it as MutableList<SymptomsModel> }
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

    fun initRoute() {
        var tmpList: MutableList<Int> = mutableListOf()
      for (i in _listSymptoms?.filter { it.selectionMark }!!)
      {
          tmpList.add(i.id)
      }
        tmpList = removeGeneralSymptom(tmpList)
        ScreenRoute.initListRoute(tmpList.distinct() as MutableList<Int>)
    }
    fun setIsEmptyList() {
        _isEmptyList = true
    }
}

private fun removeGeneralSymptom(tmpList: MutableList<Int>): MutableList<Int>
{
    val tmpListScreen: MutableList<Int> = mutableListOf()
    for (i in tmpList)
    if (Constants.mapScreens.containsKey(i))
    {
        tmpListScreen.add(i)
    }
    else{
        UserSymptoms.addUserSymptom(i)
    }
    if(tmpListScreen.size ==0)
    {
        tmpListScreen.add(0)
    }
    return tmpListScreen
}
/* viewModelScope.launch {
            var tmpList: List<Int> = try {
                repository.getIdScreenChosenSymptoms()
            } catch (t: Throwable) {
                print(t.message)
                null
            } as List<Int>
            ScreenRoute.setlistRoute(tmpList)
        }*/
