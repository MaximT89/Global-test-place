package com.secondworld.globaltestproject.core

import android.content.res.Resources
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun updateText(view: TextView, message: Any) {
    view.text = message.toString()
}

fun View.show() {
    isVisible = true
}

fun View.hide() {
    isGone = true
}

fun View.enabled() {
    isEnabled = true
    isClickable = true
}

fun View.notEnabled() {
    isEnabled = false
    isClickable = false
}

fun showViews(vararg views: View) {
    views.forEach { it.isVisible = true }
}

fun hideViews(vararg views: View) {
    views.forEach { it.isGone = true }
}

fun log(message : String){
    Log.d("TAG", "log: $message")
}

fun createGradient(textView: TextView, colors: IntArray) {
    val paint = textView.paint
    val width = paint.measureText(textView.text.toString())
    val textShader: Shader = LinearGradient(0f, 0f, width, textView.textSize, colors, null, Shader.TileMode.REPEAT)

    textView.paint.shader = textShader
}

fun Int.toDp() : Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun <T> Flow<T>.launchWhenStarted(lifecycleScope: LifecycleCoroutineScope){
    lifecycleScope.launchWhenStarted {
        this@launchWhenStarted.collect()
    }
}