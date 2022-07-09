package com.secondworld.globaltestproject.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.StateListAnimator
import android.content.Context
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class AnimationGenerator(private val coroutine: CoroutineScope) {

    fun nextAnimationSet(animatorSet: AnimatorSet, end: () -> Unit) {
        animatorSet.apply {
            start()
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    end.invoke()
                }
            })
        }
    }

    fun nextAnimationSetNew(listAnimatorSet: List<AnimatorSet>, end: () -> Unit) {
        coroutine.launch(Dispatchers.Main) {
            for (animSet in listAnimatorSet) {
                animSet.start()
                delay(animSet.duration)
            }
            delay(1500)
            end.invoke()
        }
    }
}
