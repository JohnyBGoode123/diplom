package com.example.diplom.detailedRequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.R
import com.example.diplom.common.App
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.databinding.DetailedRequestFragmentBinding
import com.example.diplom.navController
import kotlinx.android.synthetic.main.detailed_request_fragment.*

class DetailedRequestFragment : Fragment() {

    private val viewModel: DetailedRequestViewModel by viewModels {
        val args = arguments?.getIntegerArrayList("args")

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                args?.let { DetailedRequestViewModel(it, App.repositories.detailedRequest()) } as T
        }

    }
    private lateinit var dataBinding: DetailedRequestFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This callback will only be called when MyFragment is at least Started.
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.backPressButton()
        }
        // The callback can be enabled or disabled here or in the lambda
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DetailedRequestFragmentBinding.inflate(inflater, container, false)
        dataBinding.nextScreen.setOnClickListener {
            viewModel.buttonClick()

        }
        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
        dr_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        val symptomsObserver = Observer<List<ValueSymptomsModel>> {
            dr_recycler_view.adapter = DetailedRequestAdapter(it, viewModel)
        }
        dr_recycler_view.adapter?.notifyDataSetChanged()
        viewModel.listValue.observe(viewLifecycleOwner, symptomsObserver)

    }


}