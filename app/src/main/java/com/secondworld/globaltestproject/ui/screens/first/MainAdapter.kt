package com.secondworld.globaltestproject.ui.screens.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.data.OfferModel
import com.secondworld.globaltestproject.databinding.MainHolderBinding

class MainAdapter : ListAdapter<OfferModel, MainAdapter.MainHolder>(ItemComparator()) {

    class ItemComparator : DiffUtil.ItemCallback<OfferModel>() {
        override fun areItemsTheSame(oldItem: OfferModel, newItem: OfferModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OfferModel, newItem: OfferModel): Boolean {
            return oldItem == newItem
        }
    }

    var callbackDel: ((id: Int) -> Unit)? = null

    inner class MainHolder(private val binding: MainHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OfferModel) = with(binding) {

            title.text = item.date
            imageItem.setImageResource(item.image)
            nameItem.text = item.name
            price.text = item.price

            btnDelete.click {
                callbackDel?.invoke(item.id)
            }

            if(item.firstInDay) title.show()
            else title.hide()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            MainHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(getItem(position))
    }
}