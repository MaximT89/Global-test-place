package com.secondworld.globaltestproject.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

class PersonAdapter : ListAdapter<Person, PersonAdapter.RecyclerViewHolder>(ItemComparator()) {

    var callBackLongClick : ((id: Int) -> Unit)? = null
    var callBackShortClick : ((id: Int) -> Unit)? = null

    class ItemComparator : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            HolderPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun submitList(list: List<Person>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecyclerViewHolder(private val binding: HolderPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) = with(binding) {
            textPersonName.text = person.name
            textPersonAge.text = person.age.toString()

            if(person.isActive) rootPerson.setCardBackgroundColor(Color.GRAY)
            else rootPerson.setCardBackgroundColor(Color.WHITE)

            rootPerson.setOnClickListener { callBackShortClick?.invoke(person.id) }

            rootPerson.setOnLongClickListener {
                callBackLongClick?.invoke(person.id)
                true
            }
        }
    }
}