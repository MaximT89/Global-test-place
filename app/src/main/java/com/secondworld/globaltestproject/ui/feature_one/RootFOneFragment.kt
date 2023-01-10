package com.secondworld.globaltestproject.ui.feature_one

import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentRootFOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFOneFragment : BaseFragment<FragmentRootFOneBinding, RootFOneViewModel>(
    FragmentRootFOneBinding::inflate,
    RootFOneViewModel::class.java) {

    override fun initView() = Unit

    override fun initObservers() = Unit

}