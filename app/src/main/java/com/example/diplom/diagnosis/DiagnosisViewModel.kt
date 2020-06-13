package com.example.diplom.diagnosis

import android.graphics.Insets.add
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.common.UserSymptoms
import com.example.diplom.database.relationDC.DiseaseWithVariantSymptoms
import kotlinx.coroutines.launch

class DiagnosisViewModel(
    private val repository: DiagnosisRepository
) : ViewModel() {
    lateinit var listDisease: List<DiseaseWithVariantSymptoms>
    init {
        viewModelScope.launch {
            val tmpListDisease: List<DiseaseWithVariantSymptoms>? = try {
                repository.getListDisease()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            tmpListDisease?.let { listDisease = it }
        }
    }

}