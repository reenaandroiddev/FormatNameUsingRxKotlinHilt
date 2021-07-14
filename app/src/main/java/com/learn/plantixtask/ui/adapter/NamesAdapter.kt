package com.learn.plantixtask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.plantixtask.R
import com.learn.plantixtask.databinding.ListItemNamesBinding

class NamesAdapter(private val namesList: List<String>) : RecyclerView.Adapter<NamesViewHolder>() {
    override fun getItemCount(): Int {
        return namesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        val binding: ListItemNamesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(
                parent.context
            ),
            R.layout.list_item_names, parent, false
        )
        return NamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.bind(name = namesList[position])
    }

}