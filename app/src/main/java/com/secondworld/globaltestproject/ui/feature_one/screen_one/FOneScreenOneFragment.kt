package com.secondworld.globaltestproject.ui.feature_one.screen_one

import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFOneScreenOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FOneScreenOneFragment : BaseFragment<FragmentFOneScreenOneBinding, FOneScreenOneViewModel>(
    FragmentFOneScreenOneBinding::inflate,
    FOneScreenOneViewModel::class.java) {

    private val testAdapter = TestAdapter()

    override fun initView() = with(binding) {

        rv.adapter = testAdapter

        testAdapter.submitList(createSomeModels())

        btnGoNext.click {
            navigateTo(R.id.FOneScreenTwoFragment2, null,
                navOptions = NavOptions
                    .Builder()
                    .setEnterAnim(enterAnim = androidx.navigation.ui.R.anim.nav_default_enter_anim)
                    .setExitAnim(exitAnim = androidx.navigation.ui.R.anim.nav_default_exit_anim)
                    .setPopEnterAnim(popEnterAnim = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                    .setPopExitAnim(popExitAnim = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                    .build())
        }
    }

    private fun createSomeModels(): List<AdapterModel> {
        val list = mutableListOf<AdapterModel>()
        repeat(100) {
            list.add(AdapterModel((1..99999).random(), (1..999999).random().toString()))
        }
        return list
    }

    override fun initObservers() = Unit
}