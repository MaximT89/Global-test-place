package com.secondworld.globaltestproject.ui.screens.second_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment @Inject constructor(): BaseFragment<FragmentSecondBinding, SecondViewModel>(FragmentSecondBinding::inflate) {
    override val viewModel: SecondViewModel by viewModels()

    override fun initView() = with(binding){
        btnGoBack.click { navigateUp() }
    }

    override fun initObservers() {
    }
}