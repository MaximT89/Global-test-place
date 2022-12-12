package com.secondworld.globaltestproject.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.secondworld.globaltestproject.data.model.Animal

class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<Animal>(){
    override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.equals(newItem)
    }
}