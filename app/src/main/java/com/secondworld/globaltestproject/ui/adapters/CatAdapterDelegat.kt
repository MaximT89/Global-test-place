package com.secondworld.globaltestproject.ui.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.data.model.Cat
import com.secondworld.globaltestproject.databinding.HolderCatBinding

fun catAdapterDelegate(favouriteCallback : ((Int) -> Unit)?) =
    adapterDelegateViewBinding<Cat, Animal, HolderCatBinding>({ layoutInflater, root ->
        HolderCatBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            with(binding) {
                catName.text = item.name

                if (item.isFavourite) itemImgFavourite.setImageResource(R.drawable.ic_baseline_favorite_24)
                else itemImgFavourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)

                itemImgFavourite.click {
                    favouriteCallback?.invoke(item.id)
                }

            }
        }
    }