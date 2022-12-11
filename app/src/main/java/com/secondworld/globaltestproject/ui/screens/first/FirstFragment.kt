package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding

class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding) {


    }

    override fun initObservers() {
    }


}