package com.secondworld.globaltestproject.ui.feature_third

import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentRootFThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFThirdFragment : BaseFragment<FragmentRootFThirdBinding, RootFThirdViewModel>(
    FragmentRootFThirdBinding::inflate,
    RootFThirdViewModel::class.java) {
    override fun initView() = Unit

    override fun initObservers() = Unit
}