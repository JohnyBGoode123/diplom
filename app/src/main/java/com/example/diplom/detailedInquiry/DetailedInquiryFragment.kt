package com.example.diplom.detailedInquiry

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
import com.example.diplom.databinding.DetailedinquiryFragmentBinding
import kotlinx.android.synthetic.main.detailedinquiry_fragment.*

class DetailedInquiryFragment : Fragment() {

    private val viewModel: DetailedInquiryViewModel by viewModels {
        val args = arguments?.getInt("args")

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                args?.let { DetailedInquiryViewModel(it, App.repositories.cough()) } as T
        }

    }
    private lateinit var dataBinding: DetailedinquiryFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DetailedinquiryFragmentBinding.inflate(inflater, container, false)
        dataBinding.nextScreen.setOnClickListener {
            viewModel.buttonClick()

        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        cough_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        val symptomsObserver = Observer<List<ValueSymptomsModel>> {
            cough_recycler_view.adapter = DetailedInquiryAdapter(it, viewModel)
        }
        cough_recycler_view.adapter?.notifyDataSetChanged()
        viewModel.listValue.observe(viewLifecycleOwner, symptomsObserver)

    }

}