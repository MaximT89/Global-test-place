package com.secondworld.globaltestproject.core.recycler

import androidx.recyclerview.widget.DiffUtil

abstract class AbstractDiffCallback<T : Match<T>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.matchesId(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.matches(newItem)
}