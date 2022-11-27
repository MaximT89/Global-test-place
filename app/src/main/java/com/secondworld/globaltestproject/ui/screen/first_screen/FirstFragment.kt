package com.secondworld.globaltestproject.ui.screen.first_screen

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.screen.second_screen.MyView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    @SuppressLint("Recycle")
    override fun initView() = with(binding) {

        goSecondBtn.click { navigateTo(R.id.secondFragment) }

        val listColor = listOf(
            resources.getColor(R.color.red),
            resources.getColor(R.color.orange),
            resources.getColor(R.color.yellow),
            resources.getColor(R.color.green),
            resources.getColor(R.color.deep_sky_blue),
            resources.getColor(R.color.blue),
            resources.getColor(R.color.purple),
        )

        colorBgRainbow(romb1, listColor, 1, 50L)
        colorBgRainbow(romb2, listColor, 1, 100L)
        colorBgRainbow(romb3, listColor, 1, 150L)
        colorBgRainbow(romb4, listColor, 1, 200L)
        colorBgRainbow(romb5, listColor, 1, 250L)
        colorBgRainbow(romb6, listColor, 1, 300L)
        colorBgRainbow(romb7, listColor, 1, 350L)
        colorBgRainbow(romb8, listColor, 1, 400L)
        colorBgRainbow(romb9, listColor, 1, 450L)
        colorBgRainbow(romb10, listColor, 1, 500L)
        colorBgRainbow(romb11, listColor, 1, 550L)
        colorBgRainbow(romb12, listColor, 1, 600L)
        colorBgRainbow(romb13, listColor, 1, 650L)
        colorBgRainbow(romb14, listColor, 1, 750L)
        colorBgRainbow(romb15, listColor, 1, 800L)
        colorBgRainbow(romb16, listColor, 1, 850L)
        colorBgRainbow(romb17, listColor, 1, 900L)

    }

    private fun colorBgRainbow(myView: MyView, listColor: List<Int>, startColor : Int, startDelay: Long) {

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
                    myView.setColorPath(it.animatedValue as Int)
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