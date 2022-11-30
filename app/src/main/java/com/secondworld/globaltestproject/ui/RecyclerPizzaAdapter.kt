package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.secondworld.globaltestproject.databinding.PizzaHolderBinding

@SuppressLint("NotifyDataSetChanged")
class RecyclerPizzaAdapter :
    RecyclerView.Adapter<RecyclerPizzaAdapter.PizzaHolder>() {

    var items = listOf<PizzaItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // test

    inner class PizzaHolder(private val binding: PizzaHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: PizzaItem) {
            binding.pizzaWeight.text = "  ${item.weight} гр."
            binding.pizzaDescr.text = item.descr
            binding.pizzaName.text = item.name

            binding.imageMain.setBackgroundResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaHolder {
        return PizzaHolder(PizzaHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PizzaHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}