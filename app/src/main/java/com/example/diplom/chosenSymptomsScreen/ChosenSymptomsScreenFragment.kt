package com.example.diplom.chosenSymptomsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.common.App
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.databinding.FragmentFinalListsymptomsBinding
import kotlinx.android.synthetic.main.fragment_current_symptoms.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChosenSymptomsScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChosenSymptomsScreenFragment : Fragment() {

    private val viewModel: ChosenSymptomsViewModel by viewModels {



        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                ChosenSymptomsViewModel(App.repositories.chosenSymptoms()) as T
        }

    }
    private lateinit var dataBinding: FragmentFinalListsymptomsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentFinalListsymptomsBinding.inflate(inflater, container, false)
        dataBinding.button.setOnClickListener {
            if(viewModel.listSymptoms.value?.size == 0)
            {
                viewModel.setIsEmptyList()
            }

        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewmodel = viewModel
        my_recycler_view.layoutManager = LinearLayoutManager(requireContext())


        val symptomsObserver = Observer<List<SymptomsModel>> {
            my_recycler_view.adapter = ChosenSymptomsScreenAdapter(it, viewModel)

        }
        viewModel.listSymptoms.observe(viewLifecycleOwner, symptomsObserver)

    }


}