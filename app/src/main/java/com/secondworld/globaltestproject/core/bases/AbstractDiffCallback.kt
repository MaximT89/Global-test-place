package com.secondworld.globaltestproject.core.bases

import androidx.recyclerview.widget.DiffUtil

abstract class AbstractDiffCallback<T : Match<T>> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.matchesId(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.matches(newItem)
}

interface Match<T> : MatchId<T>, MatchContent<T>

interface MatchContent<T> {
    fun matches(model : T) : Boolean
}

interface MatchId<T> {
    fun matchesId(model : T) : Boolean
}