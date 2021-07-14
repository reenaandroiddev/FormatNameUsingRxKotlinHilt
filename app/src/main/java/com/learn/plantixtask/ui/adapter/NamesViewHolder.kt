package com.learn.plantixtask.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.learn.plantixtask.databinding.ListItemNamesBinding

class NamesViewHolder(private val binding: ListItemNamesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(name: String) {
        binding.name = name
    }
}