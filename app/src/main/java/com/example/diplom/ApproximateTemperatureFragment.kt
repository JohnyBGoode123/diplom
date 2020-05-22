package com.example.diplom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ApproximateTemperatureFragment : Fragment() {

    companion object {
        fun newInstance() = ApproximateTemperatureFragment()
    }

    private lateinit var viewModel: ApproximateTemperatureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.approximate_temperature_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApproximateTemperatureViewModel::class.java)
        // TODO: Use the ViewModel
    }

}