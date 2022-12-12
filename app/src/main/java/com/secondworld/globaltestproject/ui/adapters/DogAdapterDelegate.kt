package com.secondworld.globaltestproject.ui.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.data.model.Dog
import com.secondworld.globaltestproject.databinding.HolderDogBinding

fun dogAdapterDelegate() = adapterDelegateViewBinding<Dog, Animal, HolderDogBinding>({
        layoutInflater, root -> HolderDogBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.dogName.text = item.name
    }
}