package com.secondworld.globaltestproject.ui.screens.first

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.core.animation.doOnRepeat
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException


@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    @SuppressLint("Recycle")
    override fun initView() {

        getEnemy("orc.png")

        val set = AnimatorSet()
        set.playTogether(

            ObjectAnimator.ofFloat(binding.mainEnemy, View.ROTATION_Y, 0f, 360f).also {
                it.repeatCount = ObjectAnimator.INFINITE
                it.repeatMode = ObjectAnimator.RESTART
                it.interpolator = LinearInterpolator()
                it.duration = 2000
            },

//            ObjectAnimator.ofFloat(binding.mainEnemy, View.SCALE_X, 0.5f, 1f, 0.5f).also {
//                it.repeatCount = ObjectAnimator.INFINITE
//                it.repeatMode = ObjectAnimator.REVERSE
//                it.interpolator = LinearInterpolator()
//                it.duration = 1000
//            },
//            ObjectAnimator.ofFloat(binding.mainEnemy, View.SCALE_Y, 0.5f, 1f, 0.5f).also {
//                it.repeatCount = ObjectAnimator.INFINITE
//                it.repeatMode = ObjectAnimator.REVERSE
//                it.interpolator = LinearInterpolator()
//                it.duration = 1000
//            },
            )
        set.start()

    }

    private fun getEnemy(name: String) {
        try {
            requireActivity().assets.open(name).use { inputStream ->
                val drawable = Drawable.createFromStream(inputStream, null)
                binding.mainEnemy.setImageDrawable(drawable)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun initObservers() = Unit

}