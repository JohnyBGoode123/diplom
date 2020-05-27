package com.example.diplom.diagnosis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diplom.R

class DiagnosisFragment : Fragment() {

    companion object {
        fun newInstance() = DiagnosisFragment()
    }

    private lateinit var viewModel: DiagnosisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.diagnosis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiagnosisViewModel::class.java)
        // TODO: Use the ViewModel
    }

}