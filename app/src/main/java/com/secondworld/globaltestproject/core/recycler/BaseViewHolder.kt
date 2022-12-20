package com.secondworld.globaltestproject.core.recycler

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Данным классом расширяем viewHolder который будем использовать в listAdapter
 */
abstract class BaseViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item : T)
}