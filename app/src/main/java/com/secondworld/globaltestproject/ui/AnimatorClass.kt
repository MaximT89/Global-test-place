package com.secondworld.globaltestproject.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

@Suppress("UNUSED_EXPRESSION", "Recycle")
class AnimatorClass(view: View) {

    private val objectAnimator1: ObjectAnimator =
        ObjectAnimator.ofFloat(view, View.ROTATION, 1f, 90f)
    private val objectAnimator2: ObjectAnimator =
        ObjectAnimator.ofFloat(view, View.SCALE_X, 1f, 2f, 1f)
    private val objectAnimator3: ObjectAnimator =
        ObjectAnimator.ofFloat(view, View.SCALE_Y, 1f, 2f, 1f)
    private val objectAnimator4: ObjectAnimator =
        ObjectAnimator.ofFloat(view, View.ROTATION, 90f, 1f)
    private val animatorSet = AnimatorSet().playTogether(objectAnimator2, objectAnimator3)

    private inline fun foo(objectAnimator: ObjectAnimator, crossinline start: () -> Unit, crossinline end: () -> Unit) {
        with(objectAnimator) {
            duration = 3000
            start()
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    start.invoke()
                }

                override fun onAnimationEnd(animation: Animator?) {
                    end.invoke()
                }
            })
        }
    }

    fun doSome() {

        foo(objectAnimator1, {
            // start animation
        }, {
            // end animation
        })
    }
}