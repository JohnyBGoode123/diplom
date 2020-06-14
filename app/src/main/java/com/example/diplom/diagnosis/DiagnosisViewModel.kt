package com.example.diplom.diagnosis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.UserSymptoms
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms
import kotlinx.coroutines.launch

class DiagnosisViewModel(
    private val repository: DiagnosisRepository
) : ViewModel() {
    private var _idFoundDisease = 0
        set(value) {
            field = value
            (idFoundDisease as MutableLiveData).postValue(value)
        }
    val idFoundDisease: LiveData<Int> = MutableLiveData()
    init {
        viewModelScope.launch {
            val tmpListDisease: List<DiseaseWithVariantSymptoms>? = try {
                repository.getListDisease()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            tmpListDisease?.let {
                _idFoundDisease = DiagnosisAlgorithm.algorithm(UserSymptoms.getUserSymptomList(), it)
            }
        }

    }


}