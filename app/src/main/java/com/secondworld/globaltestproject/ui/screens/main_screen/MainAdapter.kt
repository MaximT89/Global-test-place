package com.secondworld.globaltestproject.ui.screens.main_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.data.local.room.UserEntity
import com.secondworld.globaltestproject.databinding.RecyclerItemBinding

@SuppressLint("NotifyDataSetChanged, SetTextI18n")
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var items = listOf<UserEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var callDeleteItem : ((id : Int) -> Unit)? = null

    inner class ViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserEntity) {
            binding.name.text = "Name : ${item.name}"
            binding.age.text = "Name : ${item.age}"

            binding.btnDelItem.click { callDeleteItem?.invoke(item.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}