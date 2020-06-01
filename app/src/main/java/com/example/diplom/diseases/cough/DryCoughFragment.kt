package com.example.diplom.diseases.cough

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diplom.R

class DryCoughFragment : Fragment() {

    companion object {
        fun newInstance() = DryCoughFragment()
    }

    private lateinit var viewModel: DryCoughViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dry_cough_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DryCoughViewModel::class.java)
        // TODO: Use the ViewModel
    }

}