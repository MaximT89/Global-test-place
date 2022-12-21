package com.secondworld.globaltestproject.ui.screens.first

import com.secondworld.globaltestproject.core.bases.AbstractDiffCallback
import com.secondworld.globaltestproject.core.bases.BaseListAdapter
import com.secondworld.globaltestproject.core.bases.BaseViewHolder
import com.secondworld.globaltestproject.core.bases.RVItemClickListener
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.data.OfferModel
import com.secondworld.globaltestproject.databinding.MainHolderBinding

class MainAdapterDiffUtilCallback : AbstractDiffCallback<OfferModel>()

class MainAdapter(
    callbackDel: (id: Int) -> Unit
) : BaseListAdapter<OfferModel, MainAdapter.TestHolder, MainHolderBinding>(
    MainAdapterDiffUtilCallback(),
    { binding -> TestHolder(binding, callbackDel) },
    MainHolderBinding::inflate,
) {

    class TestHolder(private val binding: MainHolderBinding, callbackDel: (id: Int) -> Unit) :
        BaseViewHolder<OfferModel>(binding) {

        init {
            binding.btnDelete.setOnClickListener(
                RVItemClickListener<MainAdapter> { index ->
                    callbackDel(currentList[index].id)
                }
            )
        }

        override fun bind(item: OfferModel) = with(binding) {

            title.text = item.date
            imageItem.setImageResource(item.image)
            nameItem.text = item.name
            price.text = item.price

            if (item.firstInDay) title.show()
            else title.hide()
        }
    }
}