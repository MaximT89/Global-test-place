package com.secondworld.globaltestproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

class PersonAdapter : ListAdapter<Person, PersonAdapter.RecyclerViewHolder>(ItemComparator()) {

    class ItemComparator : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return  oldItem.id == newItem.id }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return  oldItem == newItem }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            HolderPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position)) }

    inner class RecyclerViewHolder(private val binding: HolderPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            Glide.with(binding.root).load(person.image).into(binding.banner)
        }
    }
}