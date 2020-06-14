package com.example.diplom.currentSymptomsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.chooseBodyParts.ChooseBodyPartDirections
import com.example.diplom.R
import com.example.diplom.common.App
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.databinding.FragmentCurrentSymptomsBinding
import kotlinx.android.synthetic.main.fragment_current_symptoms.*


class CurrentSymptomsFragment : Fragment() {
val args: CurrentSymptomsFragmentArgs by navArgs()
     private val viewModel: CurrentSymptomsViewModel by viewModels {

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                CurrentSymptomsViewModel(args.buttonText, App.repositories.currentSymptoms()) as T
        }

    }



    private lateinit var dataBinding: FragmentCurrentSymptomsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentCurrentSymptomsBinding.inflate(inflater, container, false)
        dataBinding.acceptButton.setOnClickListener{
            viewModel.updateSymptoms()
            buttonCurrentSymptomsClick()
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner // инициализируем жизненный цикл dataBinding жизненным циклом фрагмента
        my_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        val symptomsObserver = Observer<List<SymptomsModel>> {
            my_recycler_view.adapter = CurrentSymptomsAdapter(it, viewModel)
        }
        my_recycler_view.adapter?.notifyDataSetChanged()
        viewModel.listSymptoms.observe(viewLifecycleOwner, symptomsObserver)
    }
    private fun buttonCurrentSymptomsClick() {
        val action =
            CurrentSymptomsFragmentDirections.actionCurrentSymptomsToChoosePartBodyScreen()
        this.findNavController().navigate(action)
    }
}