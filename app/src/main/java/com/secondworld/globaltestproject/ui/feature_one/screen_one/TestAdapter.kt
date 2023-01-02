package com.secondworld.globaltestproject.ui.feature_one.screen_one

import android.view.LayoutInflater
import android.view.ViewGroup
import com.secondworld.globaltestproject.core.recycler.AbstractDiffCallback
import com.secondworld.globaltestproject.core.recycler.BaseListAdapter
import com.secondworld.globaltestproject.core.recycler.BaseViewHolder
import com.secondworld.globaltestproject.databinding.HolderAnimalBinding

class Differ : AbstractDiffCallback<AdapterModel>()

class TestAdapter : BaseListAdapter<AdapterModel, TestAdapter.TestHolder>(Differ()){

    inner class TestHolder(val binding: HolderAnimalBinding) : BaseViewHolder<AdapterModel>(binding){
        override fun bind(item: AdapterModel) {
            binding.name.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        return TestHolder(HolderAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}