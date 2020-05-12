package com.example.diplom.chosenSymptomsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.R
import com.example.diplom.common.App
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsAdapter
import com.example.diplom.currentSymptomsScreen.CurrentSymptomsViewModel
import com.example.diplom.databinding.FragmentCurrentSymptomsBinding
import com.example.diplom.databinding.FragmentFinalListsymptomsBinding
import kotlinx.android.synthetic.main.fragment_current_symptoms.*

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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner

        /*LayoutManager отвечает за позиционирование view-компонентов в RecyclerView, а также за определение того, когда следует переиспользовать view-компоненты,
        которые больше не видны пользователю.*/
        // requireContext возвращает контекст, который не может быть null. Для этого эту функцию нужно вызывать когда
        // фрагмент уже создан и привязан к root (onResume, onViewCreated, etc )
        my_recycler_view.layoutManager = LinearLayoutManager(requireContext()) // Мне нужен список, поэтому вызываю LinearLayoutManager

        val symptomsObserver = Observer<List<SymptomsModel>> {
            my_recycler_view.adapter = ChosenSymptomsScreenAdapter(it, viewModel) // суть в присоединении адаптера, но

        }
        viewModel.listSymptoms.observe(viewLifecycleOwner, symptomsObserver)

    }


}