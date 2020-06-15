package com.example.diplom.diagnosis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.UserSymptoms
import com.example.diplom.common.models.DiseaseModel
import com.example.diplom.database.DaoSymptoms
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms
import kotlinx.coroutines.launch

class DiagnosisViewModel(
    private val repository: DiagnosisRepository
) : ViewModel() {
    private var _idFoundDisease = 0

    private var _foundDisease: List<DiseaseModel>? = null
        set(value) {
            field = value
            (foundDisease as MutableLiveData).postValue(value)
        }
    val foundDisease: LiveData<List<DiseaseModel>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val tmpListDisease: List<DiseaseWithVariantSymptoms>? = try {
                repository.getListDisease()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            tmpListDisease?.let {
                getDiagnosisChosenDisease(DiagnosisAlgorithm.algorithm(UserSymptoms.getUserSymptomList(), it))
            }
        }
    }
    private fun getDiagnosisChosenDisease(id: Int)
    {
        viewModelScope.launch {
            val tmpDisease: List<DiseaseModel>? = try {
                repository.getChosenDisease(id)
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            tmpDisease?.let {
                _foundDisease = it
            }
        }
    }



}