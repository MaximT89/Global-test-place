package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.data.room.EntityWord
import com.secondworld.globaltestproject.data.room.WordsWithTags
import com.secondworld.globaltestproject.databinding.HolderWordBinding
import java.lang.StringBuilder

@SuppressLint("NotifyDataSetChanged")
class WordsAdapter : RecyclerView.Adapter<WordsAdapter.WordHolder>() {

    var items = listOf<WordsWithTags>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class WordHolder(private val binding: HolderWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WordsWithTags) = with(binding) {

            enWordName.text = item.word.enWord
            ruWordName.text = item.word.ruWord

            val sb = StringBuilder()

            item.tags?.let {
                it.forEach { tag ->
                    sb.append(tag.tag).append("  ")
                }
            }

            tags.text = sb.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        return WordHolder(HolderWordBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}