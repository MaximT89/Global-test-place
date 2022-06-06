package com.secondworld.globaltestproject.ui.screens.listNote

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.databinding.NoteHolderBinding
import com.secondworld.globaltestproject.domain.models.NoteDomain

@SuppressLint("NotifyDataSetChanged")
class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    var callBack : ((id : Int) -> Unit)? = null

    var items = listOf<NoteDomain>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class NoteHolder(private val binding: NoteHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteDomain) {
            binding.noteId.text = note.id.toString()
            binding.noteText.text = note.note
            binding.root.setOnClickListener{
                callBack?.invoke(note.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        return NoteHolder(
            NoteHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}