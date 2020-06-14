package com.example.diplom.chooseBodyParts

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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.chosenSymptomsScreen.ChosenSymptomsScreenAdapter
import com.example.diplom.common.App
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.databinding.FragmentChoseSymptomsBinding
import com.example.diplom.diseases.cough.CoughFragment
import kotlinx.android.synthetic.main.fragment_current_symptoms.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseBodyPart.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChooseBodyPart : Fragment(), View.OnClickListener, ChooseBodyPartClickButtonInterface {

    private val viewModel: ChooseBodyPartViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                ChooseBodyPartViewModel(App.repositories.chosenBodyParts(), this@ChooseBodyPart) as T
        }

    }
    private lateinit var dataBinding: FragmentChoseSymptomsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentChoseSymptomsBinding.inflate(inflater, container, false)
        dataBinding.nextListSymptoms.setOnClickListener {
            buttonChosenSymptomsClick(it)
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        my_recycler_view.layoutManager = LinearLayoutManager(requireContext())


        val symptomsObserver = Observer<List<String>> {
            my_recycler_view.adapter = ChooseBodyPartAdapter(it, viewModel)

        }
        viewModel.listBodyParts.observe(viewLifecycleOwner, symptomsObserver)

    }
    private fun buttonChosenSymptomsClick(view: View) {
        val action =
            ChooseBodyPartDirections.actionChoosePartBodyScreenToChosenSymptomsScreen()
        this.findNavController().navigate(action)
    }



    override fun onClick(v: View?) {


    }

    override fun clickButton(text: String) {
        val action =
            ChooseBodyPartDirections.actionChoosePartBodyScreenToCurrentSymptoms(
                text
            )
        this.findNavController().navigate(action)
    }


}