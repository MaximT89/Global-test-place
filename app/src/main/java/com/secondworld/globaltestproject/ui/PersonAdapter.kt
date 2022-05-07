package com.secondworld.globaltestproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

class PersonAdapter : ListAdapter<Person, PersonAdapter.RecyclerViewHolder>(ItemComparator()) {

    var callBackPerson: ((position: Int, name: String) -> Unit)? = null
    var callBackPersonSecond: ((age: Int) -> Unit)? = null
    var callBackArrowUp : ((position : Int) -> Unit)? = null
    var callBackArrowDown : ((position : Int) -> Unit)? = null

    class ItemComparator : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return  oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            HolderPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecyclerViewHolder(private val binding: HolderPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {

            binding.textPersonName.text = person.name
            binding.textPersonAge.text = person.age.toString()
            binding.imageDelete.setOnClickListener {

                callBackPerson?.invoke(absoluteAdapterPosition, person.name)
                callBackPersonSecond?.invoke(person.age)
            }

            binding.imageArrowUp.setOnClickListener {
                callBackArrowUp?.invoke(absoluteAdapterPosition)
            }

            binding.imageArrowDown.setOnClickListener {
                callBackArrowDown?.invoke(absoluteAdapterPosition)
            }
        }
    }
}