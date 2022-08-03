package com.secondworld.globaltestproject.ui.fragments

import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import com.secondworld.globaltestproject.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    override fun initView() {


        binding.btnNext.setOnClickListener {
            navigateTo(R.id.thirdFragment)
        }
    }

    override fun saveLastFragment() {
        (activity as MainActivity).saveLastFragment(findNavController().currentDestination?.label!!)
    }
}