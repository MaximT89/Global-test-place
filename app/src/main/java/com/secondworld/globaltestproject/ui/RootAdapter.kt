package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.databinding.RvHolderRootBinding

@SuppressLint("NotifyDataSetChanged")
class RootAdapter(private val context: Context) :
    RecyclerView.Adapter<RootAdapter.RootViewHolder>() {

    var itemsRoot = listOf<List<Int>>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class RootViewHolder(private val binding: RvHolderRootBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: List<Int>) {
            val horizontalAdapter = HorizontalAdapter(context)
            binding.rvHorizontal.adapter = horizontalAdapter
            horizontalAdapter.items = list
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootViewHolder =
        RootViewHolder(RvHolderRootBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RootViewHolder, position: Int) {
        holder.bind(itemsRoot[position])
    }

    override fun getItemCount(): Int = itemsRoot.size
}