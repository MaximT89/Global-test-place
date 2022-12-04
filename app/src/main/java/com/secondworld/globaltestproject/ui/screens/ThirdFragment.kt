package com.secondworld.globaltestproject.ui.screens

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {
    override fun initView() = with(binding){
        btnGoFourth.click {
            navigateTo(R.id.fourthFragment)
        }

        customBackPressed(needCustomNavigate = true, resId = R.id.secondFragment)
    }

    override fun initObservers() {
    }
}