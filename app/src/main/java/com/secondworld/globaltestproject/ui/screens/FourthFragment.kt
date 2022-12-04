package com.secondworld.globaltestproject.ui.screens

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentFouthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FourthFragment : BaseFragment<FragmentFouthBinding>(FragmentFouthBinding::inflate) {
    override fun initView() = with(binding){

        btnGoThird.click {
            navigateTo(R.id.thirdFragment)
        }

        customBackPressed(needCustomNavigate = true, resId = R.id.secondFragment)
    }

    override fun initObservers() {
    }
}