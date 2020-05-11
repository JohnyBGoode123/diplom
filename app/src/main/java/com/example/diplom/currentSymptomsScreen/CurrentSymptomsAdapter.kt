package com.example.diplom.currentSymptomsScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.databinding.CurrentSymptomsListItemBinding

class CurrentSymptomsAdapter(
    private var listSymptoms: List<SymptomsModel>,
    private var viewModel: CurrentSymptomsViewModel
) : RecyclerView.Adapter<CurrentSymptomsAdapter.CurrentSymptomsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentSymptomsViewHolder {
        val dietBinding = CurrentSymptomsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CurrentSymptomsViewHolder(dietBinding)
    }

    override fun getItemCount(): Int {
        return listSymptoms.size
    }

    override fun onBindViewHolder(holder: CurrentSymptomsViewHolder, position: Int) {
        holder.symptomsBinding.listSymptomItem = listSymptoms[position]
        holder.symptomsBinding.viewmodel = viewModel
        holder.symptomsBinding.position = position
    }


    class CurrentSymptomsViewHolder( val symptomsBinding: CurrentSymptomsListItemBinding) :
        RecyclerView.ViewHolder(symptomsBinding.root)

}