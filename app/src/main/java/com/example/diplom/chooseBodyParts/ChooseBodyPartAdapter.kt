package com.example.diplom.chooseBodyParts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.databinding.ChooseBodypartListitemBinding

class ChooseBodyPartAdapter(
    private var listBodyParts: List<String>,
    private val viewModel: ChooseBodyPartViewModel
) : RecyclerView.Adapter<ChooseBodyPartAdapter.ChooseBodyPartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseBodyPartViewHolder {
        val symptomsBinding = ChooseBodypartListitemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChooseBodyPartViewHolder(symptomsBinding)
    }

    override fun getItemCount(): Int {
        return listBodyParts.size
    }

    override fun onBindViewHolder(holder: ChooseBodyPartViewHolder, position: Int) {

        holder.symptomsBinding.nameBodyPart = listBodyParts[position]
        holder.symptomsBinding.viewmodel = viewModel
    }

    class ChooseBodyPartViewHolder(val symptomsBinding: ChooseBodypartListitemBinding) :
        RecyclerView.ViewHolder(symptomsBinding.root)


}