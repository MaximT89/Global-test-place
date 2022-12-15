package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.databinding.HolderLeftMenuBinding
import com.secondworld.globaltestproject.ui.screens.first.model.left_rv.ItemLeftMenu

@SuppressLint("NotifyDataSetChanged")
class LeftMenuAdapter : RecyclerView.Adapter<LeftMenuAdapter.LeftMenuHolder>() {

    var items = listOf<ItemLeftMenu>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class LeftMenuHolder(private val binding: HolderLeftMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemLeftMenu) = with(binding) {
            imgLeftMenu.setImageResource(item.image)
            categoryNameLeftMenu.text = item.nameCategory

            if (item.isActive) isActivePoint.show()
            else isActivePoint.hide()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeftMenuHolder {
        return LeftMenuHolder(HolderLeftMenuBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: LeftMenuHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}