package com.secondworld.globaltestproject.ui.screens

import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : BaseFragment<FragmentMainScreenBinding>(FragmentMainScreenBinding::inflate) {
    override fun initView() = with(binding){

        btnGoToSearch.setOnClickListener {
            findNavController().navigate(R.id.searchScreenFragment)
        }

    }

    override fun initObservers() {
    }

}