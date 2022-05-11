package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.secondworld.globaltestproject.databinding.RvHolderHorizontalBinding

@SuppressLint("NotifyDataSetChanged")
class HorizontalAdapter(private val context: Context) : RecyclerView.Adapter<HorizontalAdapter.HorizontalHolder>() {

    var items = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalHolder {
        return HorizontalHolder(RvHolderHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class HorizontalHolder(private val binding: RvHolderHorizontalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(image : Int){

            Glide.with(context)
                .load(image)
                .into(binding.imgRv)
        }
    }
}