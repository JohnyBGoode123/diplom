package com.example.diplom.diseases.cough

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diplom.R

class WetCough : Fragment() {

    companion object {
        fun newInstance() = WetCough()
    }

    private lateinit var viewModel: WetCoughViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wet_cough_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WetCoughViewModel::class.java)
        // TODO: Use the ViewModel
    }

}