package com.secondworld.globaltestproject.core.recycler

import androidx.recyclerview.widget.DiffUtil

/**
 * Класс которым мы расширяем другой класс который потом добавляем в наш listAdapter
 */
abstract class AbstractDiffCallback<T : Match<T>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.matchesId(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.matches(newItem)
}