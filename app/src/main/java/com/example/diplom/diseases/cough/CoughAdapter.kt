package com.example.diplom.diseases.cough

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.databinding.CoughtListItemBinding
import kotlinx.android.synthetic.main.chose_symptoms_list_item.view.*

class CoughAdapter(
    private var listValue: List<ValueSymptomsModel>,
    private var viewModel: CoughViewModel
) : RecyclerView.Adapter<CoughAdapter.CoughViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoughViewHolder {
        val dietBinding = CoughtListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        dietBinding.button.setOnClickListener {
            val button: Button = it as Button
            viewModel.buttonClick(button.text.toString())
        }
        return CoughViewHolder(dietBinding)
    }

    override fun getItemCount(): Int {
       return listValue.size
    }


    override fun onBindViewHolder(
        holder: CoughViewHolder,
        position: Int
    ) {
        holder.symptomsBinding.listValueItem = listValue[position]
        holder.symptomsBinding.viewModel = viewModel
        holder.symptomsBinding.position = position
    }

    class CoughViewHolder(val symptomsBinding: CoughtListItemBinding) :
        RecyclerView.ViewHolder(symptomsBinding.root)

}