package com.secondworld.globaltestproject.ui.feature_second.screen_one

import androidx.navigation.NavOptions
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
            navigateTo(R.id.FTwoScreenTwoFragment, null,
                navOptions = NavOptions
                    .Builder()
                    .setEnterAnim(enterAnim = androidx.navigation.ui.R.anim.nav_default_enter_anim)
                    .setExitAnim(exitAnim = androidx.navigation.ui.R.anim.nav_default_exit_anim)
                    .setPopEnterAnim(popEnterAnim = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                    .setPopExitAnim(popExitAnim = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                    .build())
        }
    }

    override fun initObservers() {
    }
}