package com.secondworld.globaltestproject.ui.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.request.transition.ViewPropertyTransition
import com.secondworld.globaltestproject.core.playAllSets
import com.secondworld.globaltestproject.databinding.ActivitySecondBinding
import com.secondworld.globaltestproject.ui.AnimationGenerator
import com.secondworld.globaltestproject.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var listAnimatorSet = mutableListOf<AnimatorSet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAnimators()
        initAnimations()
    }

    private fun initAnimations() {
        listAnimatorSet.playAllSets(lifecycleScope){
            startActivity(Intent(this@SecondActivity, MainActivity::class.java))
        }
    }

    @SuppressLint("Recycle")
    private fun initAnimators() {

        val rotate = ObjectAnimator.ofFloat(binding.backLogo, View.ROTATION, 0f, 720f)
        val scaleX = ObjectAnimator.ofFloat(binding.logoBlock, View.SCALE_X, 1f, 0.5f)
        val scaleY = ObjectAnimator.ofFloat(binding.logoBlock, View.SCALE_Y, 1f, 0.5f)
        val translationY = ObjectAnimator.ofFloat(binding.logoBlock, View.TRANSLATION_Y, 1f, -580f)
        val alphaText = ObjectAnimator.ofFloat(binding.appName, View.ALPHA, 0f, 1f)
        val alphaBlackWindow = ObjectAnimator.ofFloat(binding.blackWindow, View.ALPHA, 0f, 1f)

        val animatorSet1 = AnimatorSet().apply {
            duration = 3500
            play(rotate)
        }

        val animatorSet2 = AnimatorSet().apply {
            duration = 2500
            playTogether(scaleX, scaleY)
        }

        val animatorSet3 = AnimatorSet().apply {
            duration = 3000
            play(translationY)
        }

        val animatorSet4 = AnimatorSet().apply {
            duration = 2500
            play(alphaText)
        }

        val animatorSet5 = AnimatorSet().apply {
            duration = 2500
            play(alphaBlackWindow)
        }

        listAnimatorSet.add(animatorSet1)
        listAnimatorSet.add(animatorSet2)
        listAnimatorSet.add(animatorSet3)
        listAnimatorSet.add(animatorSet4)
        listAnimatorSet.add(animatorSet5)


    }
}