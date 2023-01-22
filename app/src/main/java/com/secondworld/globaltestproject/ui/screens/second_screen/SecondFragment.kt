package com.secondworld.globaltestproject.ui.screens.second_screen

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment @Inject constructor() : BaseFragment<FragmentSecondBinding, SecondViewModel>(
    FragmentSecondBinding::inflate,
    SecondViewModel::class.java
) {

    override fun initView() = with(binding) {

        val dataFromDialog = arguments?.get("key1")
        textFromDialog.text = dataFromDialog.toString()

        btnGoFirstFragment.click { navigateTo(R.id.firstFragment) }
    }

    override fun initObservers() = Unit
}