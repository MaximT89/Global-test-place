@file:Suppress("FunctionName") // fuck off FactoryFunctions()
package com.secondworld.globaltestproject.core.bases

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
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

abstract class BaseListAdapter<D : Match<D>, VH : BaseViewHolder<D>, VB>(
    diff: AbstractDiffCallback<D>,
    private val vh: (VB) -> VH,
    private val binding: (LayoutInflater, ViewGroup, Boolean) -> VB,
) : ListAdapter<D, VH>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        vh(binding(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}

abstract class BaseViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item : T)
}

@PublishedApi internal abstract class RVItemClickListener : OnClickListener {
    override fun onClick(v: View) {
        var itemView = v
        var parent = v.parent ?: return
        while (parent !is RecyclerView) {
            itemView = parent as View
            parent = itemView.parent ?: return
        }

        val vh = parent.getChildViewHolder(itemView)
        val pos = vh.bindingAdapterPosition
        if (pos >= 0) onItemClick(vh.bindingAdapter!!, pos)
    }
    protected abstract fun onItemClick(adapter: RecyclerView.Adapter<*>, bindingPosition: Int)
}

inline fun <A : RecyclerView.Adapter<*>> RVItemClickListener(
    crossinline block: A.(Int) -> Unit,
): OnClickListener =
    object : RVItemClickListener() {
        override fun onItemClick(adapter: RecyclerView.Adapter<*>, bindingPosition: Int) {
            (adapter as A).block(bindingPosition)
        }
    }
