package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.models.PersonsList
import com.secondworld.globaltestproject.databinding.HolderListPersonsBinding
import com.secondworld.globaltestproject.databinding.HolderPersonBinding

@SuppressLint("NotifyDataSetChanged")
class PersonAdapter(private val context : Context) : RecyclerView.Adapter<BaseViewHolder>() {

//    var callBackPerson: ((position: Int) -> Unit)? = null
//    var callBackPersonSecond: ((age: Int) -> Unit)? = null

    var items = mutableListOf<RecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            R.layout.holder_person -> BaseViewHolder.SingleItemViewHolder(
                HolderPersonBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.holder_list_persons -> BaseViewHolder.ListItemViewHolder(
                HolderListPersonsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw Exception("unknown type")
        }
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

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is BaseViewHolder.SingleItemViewHolder -> holder.bind(items[position] as Person)
            is BaseViewHolder.ListItemViewHolder -> holder.bind(items[position] as PersonsList, context)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = when (items[position]) {
        is Person -> R.layout.holder_person
        is PersonsList -> R.layout.holder_list_persons
        else -> throw Exception("unknown")
    }
}

sealed class BaseViewHolder(binding : ViewBinding) : RecyclerView.ViewHolder(binding.root){

    class SingleItemViewHolder(private val binding: HolderPersonBinding) :
        BaseViewHolder(binding) {

        fun bind(person: Person) {

            binding.textPersonName.text = person.name
            binding.textPersonAge.text = person.age.toString()
        }
    }

    class ListItemViewHolder(private val binding: HolderListPersonsBinding) :
        BaseViewHolder(binding) {

        fun bind(personsList: PersonsList, context: Context) {

            binding.textTitle.text = personsList.title
            val adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1, personsList.listPerson)
            binding.listItems.adapter = adapter
        }
    }
}