package com.secondworld.globaltestproject.ui.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.data.model.Cat
import com.secondworld.globaltestproject.databinding.HolderCatBinding

fun catAdapterDelegate() = adapterDelegateViewBinding<Cat, Animal, HolderCatBinding>({
        layoutInflater, root -> HolderCatBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.catName.text = item.name
    }
}