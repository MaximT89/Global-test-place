package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.HolderBannerBinding
import com.secondworld.globaltestproject.databinding.HolderButtonBinding
import com.secondworld.globaltestproject.databinding.HolderContentTitleBinding
import com.secondworld.globaltestproject.databinding.HolderItemSmallImgBinding
import com.secondworld.globaltestproject.ui.screens.first.model.main_rv.*

@SuppressLint("NotifyDataSetChanged")
class MainContentAdapter : RecyclerView.Adapter<MainContentAdapter.MainHolder>() {

    var items = listOf<BaseContentModel>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    sealed class MainHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        class TitleHolder(private val binding: HolderContentTitleBinding) : MainHolder(binding) {
            fun bind(model : TitleModelHolder) {
                binding.titleName.text = model.title
            }
        }

        class BannerHolder(private val binding : HolderBannerBinding) : MainHolder(binding) {
            fun bind(model : BannerModelHolder){
                binding.imageBanner.setImageResource(model.image)
            }
        }

        class ButtonHolder(private val binding : HolderButtonBinding) : MainHolder(binding) {
            fun bind(model : ButtonModelHolder){
                binding.btnTitleText.text = model.title
            }
        }

        class SmallItemHolder(private val binding : HolderItemSmallImgBinding) : MainHolder(binding) {
            fun bind(model : ItemSmallModelHolder) {
                binding.imageBanner.setImageResource(model.image)
                binding.titleItem.text = model.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return when(viewType) {
            R.layout.holder_banner -> MainHolder.BannerHolder(
                HolderBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.holder_button -> MainHolder.ButtonHolder(
                HolderButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.holder_content_title -> MainHolder.TitleHolder(
                HolderContentTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.holder_item_small_img -> MainHolder.SmallItemHolder(
                HolderItemSmallImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> throw Exception("can not layout holder")
        }
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        when(holder) {
            is MainHolder.BannerHolder -> holder.bind(items[position] as BannerModelHolder)
            is MainHolder.ButtonHolder -> holder.bind(items[position] as ButtonModelHolder)
            is MainHolder.SmallItemHolder -> holder.bind(items[position] as ItemSmallModelHolder)
            is MainHolder.TitleHolder -> holder.bind(items[position] as TitleModelHolder)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]){
            is BannerModelHolder -> R.layout.holder_banner
            is ButtonModelHolder -> R.layout.holder_button
            is TitleModelHolder -> R.layout.holder_content_title
            is ItemSmallModelHolder -> R.layout.holder_item_small_img
            else -> throw Exception("unknown type")
        }
    }

    override fun getItemCount() = items.size
}