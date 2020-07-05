package com.example.diplom.detailedRequest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.R
import com.example.diplom.common.UserSymptoms
import com.example.diplom.common.models.UserSymptom
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.GroupWithValues
import com.example.diplom.navController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DetailedRequestViewModel(
    ListIdSymptom: List<Int>,
    private val repository: DetailedRequestRepository
) : ViewModel() {
    var currentSymptom = 0
    var tmpArrayBoolean = mutableListOf<Boolean>()
    private var _listValue: List<ValueSymptomsModel>? = null
        set(value) {
            field = value
            (listValue as MutableLiveData).postValue(value)
        }
    val listValue: LiveData<List<ValueSymptomsModel>> = MutableLiveData()

    private var _title: String? = null
        set(value) {
            field = value
            (title as MutableLiveData).postValue(value)
        }
    val title: LiveData<String> = MutableLiveData()
    private var _isEmptyList = false
        set(value) {
            field = value
            (isEmptyList as MutableLiveData).postValue(value)
        }
    val isEmptyList: LiveData<Boolean> = MutableLiveData(_isEmptyList)
    init {
        DetailedRequestUtils.initListSymptom(ListIdSymptom)
        setCurrentSymptom()
        getTitleSymptom()
    }


    fun radioButtonClick(position: Int) {
        tmpArrayBoolean[position] = true
        for (i in tmpArrayBoolean.indices) {
            if (i != position) {
                tmpArrayBoolean[i] = false
            }
        }
    }

    fun buttonClick() {
        if (!checkCache()) {
            if(tmpArrayBoolean.firstOrNull () { it } == null)
            {
                _isEmptyList = true
            }
            else
            {
                _isEmptyList = false
                val chosenPosition = tmpArrayBoolean.indexOfFirst { it }
                val tmp = _listValue?.get(chosenPosition)
                val tmpUserSymptom = UserSymptoms.listUserSymptom.find { it.idSymptom == currentSymptom }
                if(tmpUserSymptom!=null)
                {
                    UserSymptoms.listUserSymptom.remove(tmpUserSymptom)
                }
                tmp?.let {
                    UserSymptoms.addUserSymptom(currentSymptom,it.id)
                }
                getValueFromGroup()
            }
        }
    }

    private fun getGroupBySymptom() {
        val job = viewModelScope.launch(Dispatchers.Default) {
            val tmp: List<GroupWithValues>? = try {
                repository.getGroupWithValues(currentSymptom)
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            tmp?.let {
                DetailedRequestUtils.initListGroup(it)
            }
        }
        runBlocking {
            if (currentSymptom == 0) {
                job.cancel()
                navController?.navigate(R.id.diagnosisFragment)
                return@runBlocking
            }
            job.join()
            getValueFromGroup()
        }
    }

    private fun getValueFromGroup() {
        val listValueFromGroup = DetailedRequestUtils.getNextGroup()
        if (listValueFromGroup == null) {
            setCurrentSymptom()
            getTitleSymptom()
        } else {
            _listValue = listValueFromGroup.value
            tmpArrayBoolean.removeAll(tmpArrayBoolean)
            for (i in (_listValue as List<*>).indices) {
                tmpArrayBoolean.add(false)
            }
            DetailedRequestUtils.setListScreen(_title!!, _listValue!!)

        }
    }

    private fun setCurrentSymptom() {
        currentSymptom = DetailedRequestUtils.getNextSymptom()
    }

    private fun getTitleSymptom() {
        val jobTitle = viewModelScope.launch(Dispatchers.Default) {
            val tmp: String? = try {
                repository.getTitleSymptom(currentSymptom)
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            tmp?.let {

                _title = it
            }
        }

        runBlocking {
            jobTitle.join()
            getGroupBySymptom()
        }
    }

    fun backPressButton() {
        
        _isEmptyList = false
        tmpArrayBoolean.removeAll(tmpArrayBoolean)
        if (DetailedRequestUtils.currentItemListScreen == 0) {
            navController?.navigate(R.id.chosenSymptomsScreen)
        } else {
            DetailedRequestUtils.currentItemListScreen--
            _title =
                DetailedRequestUtils.listScreen[DetailedRequestUtils.currentItemListScreen].titleScreen
            _listValue =
                DetailedRequestUtils.listScreen[DetailedRequestUtils.currentItemListScreen].listValue
        }

    }

    private fun checkCache(): Boolean {
        return if (DetailedRequestUtils.listScreen.getOrNull(DetailedRequestUtils.currentItemListScreen + 1) == null) {
            false
        } else {
            DetailedRequestUtils.currentItemListScreen++
            _title =
                DetailedRequestUtils.listScreen[DetailedRequestUtils.currentItemListScreen].titleScreen
            _listValue =
                DetailedRequestUtils.listScreen[DetailedRequestUtils.currentItemListScreen].listValue
            true
        }
    }
}