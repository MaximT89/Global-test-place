package com.secondworld.globaltestproject.ui.feature_one.screen_two

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFOneScreenTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FOneScreenTwoFragment : BaseFragment<FragmentFOneScreenTwoBinding, FOneScreenTwoViewModel>(
    FragmentFOneScreenTwoBinding::inflate,
    FOneScreenTwoViewModel::class.java) {
    override fun initView() {
        binding.btnGoNext.click {
            navigateTo(R.id.action_FOneScreenTwoFragment2_to_FOneScreenThreeFragment2)
        }

        binding.btnGoBack.click {
            navigateTo(R.id.action_FOneScreenTwoFragment2_to_FOneScreenOneFragment2)
        }

    }

    override fun initObservers() = Unit
}