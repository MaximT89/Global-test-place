package com.secondworld.globaltestproject.ui.screen.second_screen

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, SecondViewModel>(FragmentSecondBinding::inflate) {
    override val viewModel: SecondViewModel by viewModels()

    override fun initView() {
        binding.romb.setColorPath(resources.getColor(R.color.yellow))
    }

    override fun initObservers() {
    }
}