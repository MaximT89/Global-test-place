package com.secondworld.globaltestproject.ui.fragments

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    override fun initView() = with(binding) {

        btnNext.setOnClickListener {
            val bundle = bundleOf("str" to "hello")
            navigateTo(R.id.secondFragment, bundle, null)
        }
    }

    override fun saveLastFragment() {
        (activity as MainActivity).saveLastFragment(findNavController().currentDestination?.label!!)
    }
}