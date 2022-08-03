package com.secondworld.globaltestproject.ui.fragments

import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentThirdBinding
import com.secondworld.globaltestproject.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {

    override fun initView() {
        binding.btnNext.setOnClickListener {
            navigateTo(R.id.firstFragment)
        }

        binding.btnPrev.setOnClickListener {
            navigateTo(R.id.secondFragment)
        }
    }

    override fun saveLastFragment() {
        (activity as MainActivity).saveLastFragment(findNavController().currentDestination?.label!!)
    }
}
