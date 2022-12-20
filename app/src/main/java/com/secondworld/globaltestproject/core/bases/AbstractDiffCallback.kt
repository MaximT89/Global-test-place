package com.secondworld.globaltestproject.core.bases

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.data.OfferModel
import com.secondworld.globaltestproject.databinding.MainHolderBinding

abstract class AbstractDiffCallback<T : Match<T>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.matchesId(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.matches(newItem)
}

interface Match<T> : MatchId<T>, MatchContent<T>

interface MatchContent<T> {
    fun matches(model: T): Boolean
}

interface MatchId<T> {
    fun matchesId(model: T): Boolean
}

abstract class BaseListAdapter<D : Match<D>, VH : BaseViewHolder<D>>(
    diff: AbstractDiffCallback<D>,
) : ListAdapter<D, VH>(diff) {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}

abstract class BaseViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item : T)
}


