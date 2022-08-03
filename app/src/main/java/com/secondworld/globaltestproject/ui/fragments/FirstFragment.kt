package com.secondworld.globaltestproject.ui.fragments

import android.os.CountDownTimer
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    /**
     * Splash screen
     */

    override fun initView() {

        object : CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                navigateTo(getLastFragment())
            }
        }.start()
    }

    override fun saveLastFragment() = Unit

}