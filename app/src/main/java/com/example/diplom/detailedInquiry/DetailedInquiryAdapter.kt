package com.example.diplom.detailedInquiry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.databinding.DetailedinquiryListItemBinding

class DetailedInquiryAdapter(
    private var listValue: List<ValueSymptomsModel>,
    private var viewModel: DetailedInquiryViewModel

) : RecyclerView.Adapter<DetailedInquiryAdapter.CoughViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoughViewHolder {
        val dietBinding = DetailedinquiryListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
//        dietBinding.button.setOnClickListener {
//            val button: Button = it as Button
//            viewModel.buttonClick(button.text.toString())
//        }
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
        holder.symptomsBinding.radio.setOnClickListener {
            viewModel.radioButtonClick(position)
            notifyDataSetChanged()
        }
    }

    class CoughViewHolder(val symptomsBinding: DetailedinquiryListItemBinding) :
        RecyclerView.ViewHolder(symptomsBinding.root)

}