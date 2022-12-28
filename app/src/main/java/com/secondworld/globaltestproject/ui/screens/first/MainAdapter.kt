package com.secondworld.globaltestproject.ui.screens.first

import android.view.LayoutInflater
import android.view.ViewGroup
import com.secondworld.globaltestproject.core.recycler.AbstractDiffCallback
import com.secondworld.globaltestproject.core.recycler.BaseListAdapter
import com.secondworld.globaltestproject.core.recycler.BaseViewHolder
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.databinding.HolderAnimalBinding

class AnimalDiffUtilCallback : AbstractDiffCallback<Animal>()

class MainAdapter : BaseListAdapter<Animal, MainAdapter.AnimalHolder>(
    AnimalDiffUtilCallback()
) {

    inner class AnimalHolder(private val binding: HolderAnimalBinding) :
        BaseViewHolder<Animal>(binding) {

        override fun bind(item: Animal) {
            binding.name.text = item.name
            binding.age.text = item.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        return AnimalHolder(
            HolderAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}