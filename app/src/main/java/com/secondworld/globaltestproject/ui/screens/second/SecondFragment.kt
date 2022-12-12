package com.secondworld.globaltestproject.ui.screens.second

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, SecondViewModel>(FragmentSecondBinding::inflate) {
    override val viewModel: SecondViewModel by viewModels()

    override fun initView() = with(binding){
        btnGoNext.click {
            navigateTo(R.id.thirdFragment)
        }
    }

    override fun initObservers() {
    }


}