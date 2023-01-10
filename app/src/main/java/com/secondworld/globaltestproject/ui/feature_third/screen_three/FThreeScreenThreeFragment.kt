package com.secondworld.globaltestproject.ui.feature_third.screen_three

import androidx.navigation.NavOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFThreeScreenThreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FThreeScreenThreeFragment :
    BaseFragment<FragmentFThreeScreenThreeBinding, FThreeScreenThreeViewModel>(
        FragmentFThreeScreenThreeBinding::inflate,
        FThreeScreenThreeViewModel::class.java) {
    override fun initView() {
        binding.btnGoNext.click {
            navigateTo(R.id.FThreeScreenOneFragment, null,
                navOptions = NavOptions
                    .Builder()
                    .setEnterAnim(enterAnim = ru.tinkoff.decoro.R.anim.abc_slide_in_bottom)
                    .setExitAnim(exitAnim = ru.tinkoff.decoro.R.anim.abc_slide_out_bottom)
                    .setPopEnterAnim(popEnterAnim = ru.tinkoff.decoro.R.anim.abc_slide_in_bottom)
                    .setPopExitAnim(popExitAnim = ru.tinkoff.decoro.R.anim.abc_slide_out_bottom)
                    .build())
        }
    }

    override fun initObservers() = Unit
}