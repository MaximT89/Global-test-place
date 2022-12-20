package com.secondworld.globaltestproject.ui.screens.first

import android.view.LayoutInflater
import android.view.ViewGroup
import com.secondworld.globaltestproject.core.bases.AbstractDiffCallback
import com.secondworld.globaltestproject.core.bases.BaseListAdapter
import com.secondworld.globaltestproject.core.bases.BaseViewHolder
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.data.OfferModel
import com.secondworld.globaltestproject.databinding.MainHolderBinding

class MainAdapterDiffUtilCallback : AbstractDiffCallback<OfferModel>()

class MainAdapter : BaseListAdapter<OfferModel,
        MainAdapter.TestHolder>(MainAdapterDiffUtilCallback()) {

    var callbackDel: ((id: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        return TestHolder(
            MainHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class TestHolder(private val binding: MainHolderBinding) :
        BaseViewHolder<OfferModel>(binding) {

        override fun bind(item: OfferModel) = with(binding) {

            title.text = item.date
            imageItem.setImageResource(item.image)
            nameItem.text = item.name
            price.text = item.price

            btnDelete.click { callbackDel?.invoke(item.id) }

            if (item.firstInDay) title.show()
            else title.hide()
        }
    }
}