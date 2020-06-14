package com.example.diplom.diseases.cough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.common.App
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.databinding.CoughFragmentBinding
import kotlinx.android.synthetic.main.cough_fragment.*

class CoughFragment : Fragment() {

    private val viewModel: CoughViewModel by viewModels {
        val args = arguments?.getInt("args")

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                args?.let { CoughViewModel(it, App.repositories.cough()) } as T
        }

    }
    private lateinit var dataBinding: CoughFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = CoughFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        cough_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        val symptomsObserver = Observer<List<ValueSymptomsModel>> {
            cough_recycler_view.adapter = CoughAdapter(it, viewModel)
        }
        cough_recycler_view.adapter?.notifyDataSetChanged()
        viewModel.listValue.observe(viewLifecycleOwner, symptomsObserver)

    }

}