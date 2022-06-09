package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

@SuppressLint("NotifyDataSetChanged")
class PersonAdapter : RecyclerView.Adapter<PersonAdapter.RecyclerViewHolder>() {

    var callBackPerson: ((position: Int) -> Unit)? = null
    var callBackPersonSecond: ((age: Int) -> Unit)? = null

    var items = mutableListOf<Person>()
        set(value) {
            field = value
            notifyDataSetChanged()
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

    fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                items[i] = items.set(i + 1, items[i]);
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                items[i] = items.set(i - 1, items[i])
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun deleteItem(absoluteAdapterPosition: Int) {
        callBackPerson?.invoke(absoluteAdapterPosition)
    }

    inner class RecyclerViewHolder(private val binding: HolderPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {

            binding.textPersonName.text = person.name
            binding.textPersonAge.text = person.age.toString()
            binding.imageDelete.setOnClickListener {

                deleteItem(absoluteAdapterPosition)
                callBackPersonSecond?.invoke(person.age)
            }
        }
    }
}