package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

class PersonAdapter : ListAdapter<Person, PersonAdapter.RecyclerViewHolder>(ItemComparator()) {

    class ItemComparator : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            HolderPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun moveItem(fromPosition: Int, toPosition: Int) {
        val list = currentList.toMutableList()
        val fromItem = list[fromPosition]
        list.removeAt(fromPosition)

        if (toPosition < fromPosition) list.add(toPosition + 1, fromItem)
        else list.add(toPosition - 1, fromItem)

        this.submitList(list)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecyclerViewHolder(private val binding: HolderPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(person: Person) {
            binding.userName.text = "Имя : ${person.name}"
            binding.userAge.text = "Возраст : ${person.age}"
            binding.userActive.text = "Активность : ${person.isActive}"
            binding.userProfession.text = "Профессия : ${person.profession}"

            binding.userYearBorn.text = (2022 - person.age).toString()
        }
    }
}