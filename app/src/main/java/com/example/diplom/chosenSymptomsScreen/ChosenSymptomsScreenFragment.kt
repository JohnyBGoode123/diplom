package com.example.diplom.chosenSymptomsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diplom.R
import com.example.diplom.common.App
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsViewModel
import com.example.diplom.databinding.FragmentCurrentSymptomsBinding
import com.example.diplom.databinding.FragmentFinalListsymptomsBinding

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
                ChosenSymptomsViewModel( App.repositories.chosenSymptoms()) as T
        }

    }
    private lateinit var dataBinding: FragmentFinalListsymptomsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentFinalListsymptomsBinding.inflate(inflater, container, false)
        return dataBinding.root
    }


}