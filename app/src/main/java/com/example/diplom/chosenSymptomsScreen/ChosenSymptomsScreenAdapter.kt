package com.example.diplom.chosenSymptomsScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.common.models.SymptomsModel
import com.example.diplom.databinding.ChoseSymptomsListItemBinding

class ChosenSymptomsScreenAdapter(
    private var listSymptoms: List<SymptomsModel>,
    private var viewModel: ChosenSymptomsViewModel
) : RecyclerView.Adapter<ChosenSymptomsScreenAdapter.ChosenSymptomsScreenViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChosenSymptomsScreenViewHolder {
        val symptomsBinding = ChoseSymptomsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChosenSymptomsScreenViewHolder(symptomsBinding)
    }

    override fun getItemCount(): Int {
        return listSymptoms.size
    }

    override fun onBindViewHolder(holder: ChosenSymptomsScreenViewHolder, position: Int) {
        holder.symptomsBinding.symptomName = listSymptoms[position].nameSymptom
        holder.symptomsBinding.viewmodel = viewModel
        holder.symptomsBinding.imageButton.setOnClickListener {
            viewModel.updateSymptom(listSymptoms[position].nameSymptom)
            deleteItem(holder.adapterPosition)
        }
    }

    class ChosenSymptomsScreenViewHolder(val symptomsBinding: ChoseSymptomsListItemBinding) :
        RecyclerView.ViewHolder(symptomsBinding.root)
    private fun deleteItem(position: Int)
    {
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, itemCount);
    }
}