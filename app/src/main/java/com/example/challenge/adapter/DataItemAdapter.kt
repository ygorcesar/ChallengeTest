package com.example.challenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge.databinding.DataItemViewBinding
import com.example.challenge.model.Data

class DataItemAdapter(
    private val dataEntries: List<Data>,
    private val onItemClick: (Data) -> Unit,
) : RecyclerView.Adapter<DataItemAdapter.DataItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = DataItemViewHolder(DataItemViewBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: DataItemViewHolder, position: Int) {
        val data = dataEntries[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int = dataEntries.size

    inner class DataItemViewHolder(
        private val binding: DataItemViewBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Data) {
            binding.textTitle.text = data.title
            binding.textDescription.text = data.description
            binding.root.setOnClickListener { onItemClick.invoke(data) }
        }
    }
}