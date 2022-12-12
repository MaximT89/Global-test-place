package com.secondworld.globaltestproject.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.data.model.Cat

class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<Animal>(){
    override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.equals(newItem)
    }

    override fun getChangePayload(oldItem: Animal, newItem: Animal): Any? {
        if(oldItem is Cat && newItem is Cat) {
            return if (oldItem.isFavourite != newItem.isFavourite) true else null
        }
        return null
    }
}