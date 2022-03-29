package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.models.Student
import com.secondworld.globaltestproject.databinding.PersonHolderBinding
import com.secondworld.globaltestproject.databinding.StudentHolderBinding

@SuppressLint("NotifyDataSetChanged")
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    var items = listOf<RecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var callBackTest : ((view : View, item : RecyclerViewItem, position : Int) -> Unit)? = null

    // TODO: при клике на элемент закрашивать весь холдер

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return when (viewType) {
            R.layout.person_holder -> RecyclerViewHolder.PersonHolder(
                PersonHolderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.student_holder -> RecyclerViewHolder.StudentHolder(
                StudentHolderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw Exception("unknown type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.callBackTest = callBackTest
        when (holder) {
            is RecyclerViewHolder.PersonHolder -> holder.bind(items[position] as Person)
            is RecyclerViewHolder.StudentHolder -> holder.bind(items[position] as Student)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = when (items[position]) {
        is Person -> R.layout.person_holder
        is Student -> R.layout.student_holder
        else -> throw Exception("unknown")
    }
}