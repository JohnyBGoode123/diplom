package com.example.diplom.currentSymptomsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentCurrentSymptomsBinding.inflate(inflater, container, false)
        dataBinding.acceptButton.setOnClickListener{
            viewModel.updateSymptoms()}
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

        val symptomsObserver = Observer<List<SymptomsModel>> { it ->
            my_recycler_view.adapter = CurrentSymptomsAdapter(it, viewModel) // суть в присоединении адаптера, но
        }
        viewModel.listSymptoms.observe(viewLifecycleOwner, symptomsObserver)

    }
}