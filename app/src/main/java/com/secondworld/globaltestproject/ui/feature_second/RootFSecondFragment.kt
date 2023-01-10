package com.secondworld.globaltestproject.ui.feature_second

import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentRootFSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFSecondFragment : BaseFragment<FragmentRootFSecondBinding, RootFSecondViewModel>(
    FragmentRootFSecondBinding::inflate,
    RootFSecondViewModel::class.java) {
    override fun initView() = Unit

    override fun initObservers() = Unit

}