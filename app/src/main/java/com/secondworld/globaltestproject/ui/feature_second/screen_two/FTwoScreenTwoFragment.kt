package com.secondworld.globaltestproject.ui.feature_second.screen_two

import androidx.navigation.NavOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFTwoScreenTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FTwoScreenTwoFragment : BaseFragment<FragmentFTwoScreenTwoBinding, FTwoScreenTwoViewModel>(
    FragmentFTwoScreenTwoBinding::inflate,
    FTwoScreenTwoViewModel::class.java) {

    override fun initView() {
        binding.btnGoNext.click {
            navigateTo(R.id.FTwoScreenThreeFragment)
        }
    }

    override fun initObservers() {
    }
}