package com.secondworld.globaltestproject.ui.animals

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.AnimalHolderBinding
import com.secondworld.globaltestproject.domain.animal.model.AnimalModel

@SuppressLint("NotifyDataSetChanged")
class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {

    var items = listOf<AnimalModel>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class AnimalHolder(private val binding: AnimalHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(animalModel: AnimalModel) {
            binding.textNameAnimal.text = animalModel.name
            binding.textDietAnimal.text = animalModel.diet
            binding.textTypeAnimal.text = animalModel.animalType

            binding.imgAnimal.load(animalModel.imageLink){
                placeholder(R.drawable.cat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        return AnimalHolder(
            AnimalHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}