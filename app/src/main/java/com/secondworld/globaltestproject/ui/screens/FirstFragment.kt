package com.secondworld.globaltestproject.ui.screens

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    override fun initView() = with(binding){

        btnGoNext.click {
            navigateTo(R.id.action_firstFragment_to_secondFragment)
        }

    }

    override fun initObservers() {
    }
}