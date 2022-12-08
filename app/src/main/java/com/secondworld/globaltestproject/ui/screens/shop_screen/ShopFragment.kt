package com.secondworld.globaltestproject.ui.screens.shop_screen

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.Destinations
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentShopBinding
import com.secondworld.globaltestproject.ui.models.MusicStore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding, ShopViewModel>(FragmentShopBinding::inflate) {
    override val viewModel: ShopViewModel by viewModels()

    override val musicBg: Int = MusicStore.MUSIC_SHOP_BG.track

    override fun initView() = with(binding){
        btnGoMain.click { navigateTo(Destinations.SHOP_TO_MAIN.id) }
    }

    override fun initObservers() {}
}