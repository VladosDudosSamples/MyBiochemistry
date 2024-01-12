package com.example.mybiochemistry.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybiochemistry.databinding.BiochemistryListElementBinding
import com.example.mybiochemistry.model.PartListModel

class ListMoleculeAdapter(private val context: Context, private val list: List<PartListModel>) : RecyclerView.Adapter<ListMoleculeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BiochemistryListElementBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.image.setImageResource(list[position].image)
        holder.binding.image.setOnClickListener {  }

        holder.binding.textName.text = list[position].name
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: BiochemistryListElementBinding) :
        RecyclerView.ViewHolder(binding.root)
}