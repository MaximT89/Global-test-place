package com.secondworld.globaltestproject.ui.screens.first

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Outline
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewOutlineProvider
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.bases.BaseResult
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.core.remote.Failure
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException


@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    var status = true

    @SuppressLint("Recycle")
    override fun initView() {

        getEnemy("orc.png", binding.mainEnemy2)
        getEnemy("orc.png", binding.mainEnemy3)

        createOutline(binding.mainEnemy1)

        binding.mainEnemy1.click {
            animationRorateY(binding.mainEnemy1)
        }
        binding.mainEnemy2.click {
            animationRorateY(binding.mainEnemy2)
        }
        binding.mainEnemy3.click {
            animationRorateY(binding.mainEnemy3)
        }
    }

    private fun createOutline(view : View) {
        val viewOutlineProvider: ViewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.height, (view.height+40f).toInt(), 40f)
            }
        }

        view.outlineProvider = viewOutlineProvider
        view.clipToOutline = true
    }

    private fun animationRorateY(view: ImageView) {

        val animatorRotate = ObjectAnimator.ofFloat(view, View.ROTATION_Y, 0f, 90f).also {
            it.repeatCount = 1
            it.repeatMode = ObjectAnimator.REVERSE
            it.interpolator = LinearInterpolator()
            it.duration = 300
        }

        animatorRotate.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(p0: Animator?) {
                view.isEnabled = true
            }

            override fun onAnimationCancel(p0: Animator?) = Unit

            override fun onAnimationRepeat(p0: Animator?) {
                if(status) {
                    getEnemy("orc.png", binding.mainEnemy1)
                    status = !status
                } else {
                    view.setImageResource(R.drawable.back)
                    status = !status
                }
            }
        })

        val set = AnimatorSet()
        set.play(animatorRotate)
        set.start()
    }

    private fun getAssetsImg(name: String, view: ImageView) {
        try {
            requireActivity().assets.open(name).use { inputStream ->
                val drawable = Drawable.createFromStream(inputStream, null)
                view.setImageDrawable(drawable)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun getAssetsImg(name: String) : BaseResult<Drawable, Failure> {
        return try {
            context.assets.open(name).use { inputStream ->
                BaseResult.Success(Drawable.createFromStream(inputStream, null))
            }
        } catch (e: IOException) {
            BaseResult.Error(Failure(code = -1, e.message.toString()))
        }
    }

    override fun initObservers() = Unit

}