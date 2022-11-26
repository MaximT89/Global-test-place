package com.secondworld.globaltestproject.ui.screens.arena_screen

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.Destinations
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentArenaBinding
import com.secondworld.globaltestproject.ui.MainActivity
import com.secondworld.globaltestproject.ui.models.MusicStore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArenaFragment :
    BaseFragment<FragmentArenaBinding, ArenaViewModel>(FragmentArenaBinding::inflate) {

    override val viewModel: ArenaViewModel by viewModels()

    override val musicBg: Int = MusicStore.MUSIC_FIGHT_BG.track

    override fun initView() = with(binding) {
        btnGoMain.click { navigateTo(Destinations.ARENA_TO_MAIN.id) }
    }

    override fun initObservers() {}
}