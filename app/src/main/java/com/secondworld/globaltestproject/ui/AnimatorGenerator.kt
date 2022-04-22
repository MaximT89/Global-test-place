package com.secondworld.globaltestproject.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet

class AnimatorGenerator {
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
}
