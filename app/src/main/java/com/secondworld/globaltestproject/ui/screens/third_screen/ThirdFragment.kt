package com.secondworld.globaltestproject.ui.screens.third_screen

import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : BaseFragment<FragmentThirdBinding, ThirdViewModel>(FragmentThirdBinding::inflate, ThirdViewModel::class.java) {
    override fun initView() {

        binding.btnBack.click {
            requireActivity().onBackPressed()
        }

    }

    override fun initObservers() {
    }
}