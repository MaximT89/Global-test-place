package com.secondworld.globaltestproject.ui.feature_one.screen_three

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.databinding.FragmentFOneScreenThreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FOneScreenThreeFragment :
    BaseFragment<FragmentFOneScreenThreeBinding, FOneScreenThreeViewModel>(
        FragmentFOneScreenThreeBinding::inflate,
        FOneScreenThreeViewModel::class.java) {

    override fun initView(){
        binding.btnGoNext.click { navigateTo(R.id.action_FOneScreenThreeFragment2_to_FOneScreenOneFragment2) }

    }

    override fun initObservers() = Unit
}