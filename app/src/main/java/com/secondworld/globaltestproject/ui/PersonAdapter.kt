package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

@SuppressLint("NotifyDataSetChanged")
class PersonAdapter : RecyclerView.Adapter<PersonAdapter.RecyclerViewHolder>(){

    var callBackPerson: ((position: Int, name : String) -> Unit)? = null
    var callBackPersonSecond: ((age: Int) -> Unit)? = null


    var items = mutableListOf<Person>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun removePerson(position : Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(HolderPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class RecyclerViewHolder(private val binding: HolderPersonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(person: Person){

            binding.textPersonName.text = person.name
            binding.textPersonAge.text = person.age.toString()

            binding.imageDelete.setOnClickListener {

                callBackPerson?.invoke(absoluteAdapterPosition, person.name)

                callBackPersonSecond?.invoke(person.age)

            }
        }
    }

}