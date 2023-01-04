package com.secondworld.globaltestproject.ui.feature_second.screen_one

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFTwoScreenOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FTwoScreenOneFragment : BaseFragment<FragmentFTwoScreenOneBinding, FTwoScreenOneViewModel>(
    FragmentFTwoScreenOneBinding::inflate,
    FTwoScreenOneViewModel::class.java) {
    override fun initView() {
        binding.btnGoNext.click {
            navigateTo(R.id.FTwoScreenTwoFragment)
        }
    }

    override fun initObservers() {
    }
}