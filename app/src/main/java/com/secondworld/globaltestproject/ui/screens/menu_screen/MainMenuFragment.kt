package com.secondworld.globaltestproject.ui.screens.menu_screen

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.Destinations
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentMainMenuBinding
import com.secondworld.globaltestproject.ui.MainActivity
import com.secondworld.globaltestproject.ui.models.MusicStore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMenuFragment :
    BaseFragment<FragmentMainMenuBinding, MainMenuViewModel>(FragmentMainMenuBinding::inflate) {

    override val viewModel: MainMenuViewModel by viewModels()

    override val musicBg: Int = MusicStore.MUSIC_MAIN_BG.track

    override fun initView() = with(binding){

        btnGoArena.click { navigateTo(Destinations.MAIN_TO_ARENA.id) }
        btnGoShop.click { navigateTo(Destinations.MAIN_TO_SHOP.id) }
    }

    override fun initObservers() {}

}