package com.secondworld.globaltestproject.ui.feature_second.screen_three

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFTwoScreenThreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FTwoScreenThreeFragment :
    BaseFragment<FragmentFTwoScreenThreeBinding, FTwoScreenThreeViewModel>(
        FragmentFTwoScreenThreeBinding::inflate,
        FTwoScreenThreeViewModel::class.java) {
    override fun initView() {
        binding.btnGoNext.click {
            navigateTo(R.id.FTwoScreenOneFragment)
        }
    }

    override fun initObservers() = Unit
}