package com.secondworld.globaltestproject.ui.activities

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.INFINITE
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.ActivitySecondBinding
import com.secondworld.globaltestproject.ui.AnimatorGenerator

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var listAnimatorSet = mutableListOf<AnimatorSet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAnimators()
        initGodClass()
    }

    private fun initGodClass() {
        val animatorGenerator = AnimatorGenerator().apply {
            nextAnimationSet(listAnimatorSet[0]){
                nextAnimationSet(listAnimatorSet[1]){

                }
            }
        }
    }

    @SuppressLint("Recycle")
    private fun initAnimators() {

        val rotate = ObjectAnimator.ofFloat(binding.backLogo, View.ROTATION, 0f, 360f)
        val scaleX = ObjectAnimator.ofFloat(binding.backLogo, View.SCALE_X, 1f, 2f, 1f)
        val scaleY = ObjectAnimator.ofFloat(binding.backLogo, View.SCALE_Y, 1f, 2f, 1f)

        val animatorSet1 = AnimatorSet().apply {
            duration = 2000
            play(rotate)
        }

        val animatorSet2 = AnimatorSet().apply {
            duration = 10000
            playTogether(scaleX, scaleY)
        }

        listAnimatorSet.add(animatorSet1)
        listAnimatorSet.add(animatorSet2)


    }
}