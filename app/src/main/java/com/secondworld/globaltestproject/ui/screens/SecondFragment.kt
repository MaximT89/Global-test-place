package com.secondworld.globaltestproject.ui.screens

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {
    override fun initView() = with(binding){

        btnGoThird.click {
            navigateTo(R.id.thirdFragment)
        }

        btnGoFourth.click {
            navigateTo(R.id.fourthFragment)
        }

    }

    override fun initObservers() {
    }
}