package com.secondworld.globaltestproject.ui.screens.first

import android.os.CountDownTimer
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    var currentProgress = 0

    override fun initView() {

        object : CountDownTimer(5000, 50) {
            override fun onTick(p0: Long) {
                currentProgress++
                binding.progressB.setProgress(currentProgress)
            }

            override fun onFinish() {
                navigateTo(R.id.action_firstFragment_to_secondFragment)
            }
        }.start()

        binding.btnTest.click {
            navigateTo(R.id.action_firstFragment_to_secondFragment)
        }
    }

    override fun initObservers() = Unit
}

