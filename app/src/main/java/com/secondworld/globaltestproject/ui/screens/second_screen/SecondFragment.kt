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

        btnGoBack.click {
            requireActivity().onBackPressed()
        }

        btnSendMessage.click {
            navigateTo(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun initObservers() = Unit
}