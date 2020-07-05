package com.example.diplom.detailedRequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.common.models.ValueSymptomsModel
import com.example.diplom.databinding.DetailedrequestListTemBinding

class DetailedRequestAdapter(
    private var listValue: List<ValueSymptomsModel>,
    private var viewModel: DetailedRequestViewModel
) : RecyclerView.Adapter<DetailedRequestAdapter.DetailedRequestHolder>() {


    class DetailedRequestHolder(val symptomsBinding: DetailedrequestListTemBinding) :
        RecyclerView.ViewHolder(symptomsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedRequestHolder {
        val dietBinding = DetailedrequestListTemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DetailedRequestHolder(dietBinding)
    }

    override fun getItemCount(): Int {
        return listValue.size
    }

    override fun onBindViewHolder(holder: DetailedRequestHolder, position: Int) {
        holder.symptomsBinding.listValueItem = listValue[position]
        holder.symptomsBinding.viewModel = viewModel
        holder.symptomsBinding.position = position
        holder.symptomsBinding.radio.setOnClickListener {
            viewModel.radioButtonClick(position)
            notifyDataSetChanged()
        }
    }
}