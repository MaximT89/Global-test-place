package com.secondworld.globaltestproject.core.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<M : Match<M>, VH : BaseViewHolder<M>>(
    diff: AbstractDiffCallback<M>,
) : ListAdapter<M, VH>(diff) {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}