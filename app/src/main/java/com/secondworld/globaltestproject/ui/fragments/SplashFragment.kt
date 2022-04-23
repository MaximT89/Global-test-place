package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import android.view.View
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}