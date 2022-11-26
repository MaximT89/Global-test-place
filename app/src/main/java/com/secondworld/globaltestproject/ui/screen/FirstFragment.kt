package com.secondworld.globaltestproject.ui.screen

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    @SuppressLint("Recycle")
    override fun initView() = with(binding) {

        val listColor = listOf(
            resources.getColor(R.color.red),
            resources.getColor(R.color.orange),
            resources.getColor(R.color.yellow),
            resources.getColor(R.color.green),
            resources.getColor(R.color.deep_sky_blue),
            resources.getColor(R.color.blue),
            resources.getColor(R.color.purple),
        )

        colorBgRainbow(textTest1, listColor, 0, 0L)
        colorBgRainbow(textTest2, listColor, 0, 50L)
        colorBgRainbow(textTest3, listColor, 0, 100L)
        colorBgRainbow(textTest4, listColor, 0, 150L)
        colorBgRainbow(textTest5, listColor, 0, 200L)
        colorBgRainbow(textTest6, listColor, 0, 250L)
        colorBgRainbow(textTest7, listColor, 0, 300L)
        colorBgRainbow(textTest8, listColor, 0, 350L)
        colorBgRainbow(textTest9, listColor, 0, 400L)
        colorBgRainbow(textTest10, listColor, 0, 450L)

    }

    private fun colorBgRainbow(textTest: TextView, listColor: List<Int>, startColor : Int, startDelay: Long) {

        val durationAnimate = 600L

        var colorFromIndex = startColor
        var colorToIndex = startColor + 1

        CoroutineScope(Dispatchers.Main).launch {

            delay(startDelay)

            while (true) {
                val animator = ValueAnimator.ofObject(
                    ArgbEvaluator(),
                    listColor[colorFromIndex],
                    listColor[colorToIndex]
                )
                animator.duration = durationAnimate

                animator.addUpdateListener {
                    textTest.setBackgroundColor(it.animatedValue as Int)
                }

                colorFromIndex++
                if (colorFromIndex > listColor.size - 1) colorFromIndex = 0

                colorToIndex++
                if (colorToIndex > listColor.size - 1) colorToIndex = 0

                animator.start()
                delay(durationAnimate)

            }
        }


    }

    override fun initObservers() {
    }
}