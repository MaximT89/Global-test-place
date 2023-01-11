package com.secondworld.globaltestproject.ui.screens.first

import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.getColor
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    override fun initView() {

        binding.btnTest.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.red))

        binding.btnTest.setBackgroundColor(getColor(R.color.red))

    }

    override fun initObservers() = Unit

}