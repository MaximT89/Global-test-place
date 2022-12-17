package com.secondworld.globaltestproject.ui.screens

import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentSearchScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchScreenFragment : BaseFragment<FragmentSearchScreenBinding>(FragmentSearchScreenBinding::inflate) {
    override fun initView() {

        binding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.mainScreenFragment)
        }

    }

    override fun initObservers() {
    }
}