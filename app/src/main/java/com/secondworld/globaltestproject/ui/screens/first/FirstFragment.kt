package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding) {
        btnGoNext.click { navigateTo(R.id.secondFragment) }
    }

    override fun initObservers() = with(viewModel){

    }
}