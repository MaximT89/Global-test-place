package com.secondworld.globaltestproject.ui.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.secondworld.globaltestproject.data.model.Animal

class MainScreenAdapter : AsyncListDifferDelegationAdapter<Animal>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager
            .addDelegate(catAdapterDelegate())
            .addDelegate(dogAdapterDelegate())
    }
}