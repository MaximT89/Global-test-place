package com.secondworld.globaltestproject.ui.screens.first

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.view.View
import androidx.core.content.ContextCompat
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    var currentProgress = 0

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun initView() {


        binding.btnTest.click {
            binding.imageTest1.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.ic_baseline_brightness_1_24))
            val animate1 = ObjectAnimator.ofFloat(binding.imageTest1, View.SCALE_X, 0f, 1f)
            val animate2 = ObjectAnimator.ofFloat(binding.imageTest1, View.SCALE_Y, 0f, 1f)

            AnimatorSet().apply {
                duration = 500
                playTogether(animate1, animate2)
                start()
            }
        }
    }

    override fun initObservers() = Unit
}

