package com.secondworld.globaltestproject.ui.screens.second_screen

import android.app.Activity
import android.content.Intent
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
        btnGoBack.click { navigateUp() }

        btnSendMessage.click {}
    }

    override fun initObservers() = Unit
}