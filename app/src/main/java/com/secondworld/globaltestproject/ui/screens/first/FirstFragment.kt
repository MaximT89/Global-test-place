package com.secondworld.globaltestproject.ui.screens.first

import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate,
        FirstViewModel::class.java
    ) {

    override fun initView() = Unit

    override fun initObservers() = Unit

}