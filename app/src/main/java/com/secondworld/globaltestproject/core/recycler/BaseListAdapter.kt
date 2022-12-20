package com.secondworld.globaltestproject.core.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

/**
 * Базовый listAdapter расширяем им лист
 */
abstract class BaseListAdapter<D : Match<D>, VH : BaseViewHolder<D>>(
    diff: AbstractDiffCallback<D>,
) : ListAdapter<D, VH>(diff) {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}