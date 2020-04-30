package com.example.diplom.currentSymptomsScreen

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.databinding.CurrentSymptomsBinding

class CurrentSymptomsAdapter(
    private var listSymptoms: List<SymptomsModel>,
    private var viewModel: CurrentSymptomsViewModel
):RecyclerView.Adapter<CurrentSymptomsAdapter.CurrentSymptomsViewHolder>() {


    class CurrentSymptomsViewHolder(private val symptomsBinding: CurrentSymptomsBinding):RecyclerView.ViewHolder(symptomsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentSymptomsViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CurrentSymptomsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}