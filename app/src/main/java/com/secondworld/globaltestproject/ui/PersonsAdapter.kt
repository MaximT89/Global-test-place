package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.HolderPersonItemBinding
import com.secondworld.globaltestproject.ui.model.PersonItem
import java.lang.StringBuilder

@SuppressLint("SetTextI18n")
class PersonsAdapter : ListAdapter<PersonItem, PersonsAdapter.PersonViewHolder>(ItemComparator()) {

    class ItemComparator : DiffUtil.ItemCallback<PersonItem>() {
        override fun areItemsTheSame(oldItem: PersonItem, newItem: PersonItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PersonItem, newItem: PersonItem) =
            oldItem == newItem
    }

    inner class PersonViewHolder(private val binding: HolderPersonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PersonItem) = with(binding) {
            name.text = item.name
            description.text = item.descr
            age.text = "Age : ${item.age}"

            val sb = StringBuilder()
            sb.append("  ")
            item.professions?.forEach { sb.append(it.ru).append(", ") }
            professions.text = sb.toString().dropLast(2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            HolderPersonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}