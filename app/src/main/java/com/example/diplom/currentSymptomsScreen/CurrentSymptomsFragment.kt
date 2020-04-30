package com.example.diplom.currentSymptomsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diplom.R
import com.example.diplom.common.App

class CurrentSymptomsFragment : Fragment() {
    private val viewModel: CurrentSymptomsViewModel by viewModels {

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                CurrentSymptomsViewModel("Голова", App.repositories.currentSymptoms()) as T
        }
    }
   // private lateinit var dataBinding: CurrentSymptomsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_symptoms, container, false)
    }
}