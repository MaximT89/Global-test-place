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
        binding.btnGoNext.click { navigateTo(R.id.FOneScreenOneFragment2, null,
            navOptions = NavOptions
                .Builder()
                .setEnterAnim(enterAnim = androidx.navigation.ui.R.anim.nav_default_enter_anim)
                .setExitAnim(exitAnim = androidx.navigation.ui.R.anim.nav_default_exit_anim)
                .setPopEnterAnim(popEnterAnim = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(popExitAnim = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                .build())  }

    }

    override fun initObservers() = Unit
}