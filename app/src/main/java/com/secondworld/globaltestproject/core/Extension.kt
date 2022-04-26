package com.secondworld.globaltestproject.core

import android.content.res.Resources
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData


fun updateText(view: TextView, message: Any) {
    view.text = message.toString()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.enabled() {
    isEnabled = true
    isClickable = true
}


fun View.notEnabled() {
    isEnabled = false
    isClickable = false
}

// Удаление элемента по позиции из liveData
fun <T> removeItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    list.value.apply {
        this?.removeAt(position)
        list.value = this
    }
}

// Переместить элемент вверх в recyclerView (listView)
fun <T> upItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    if (position != 0) {
        list.value.also {
            val personTemp = it?.get(position)
            it?.apply {
                removeAt(position)
                add(position.dec(), personTemp!!)
                list.value = this
            }
        }
    } else list.value
}

// Переместить элемент вниз в recyclerView (listView)
fun <T> downItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    if (position != list.value?.size?.minus(1)) {
        list.value.also {
            val personTemp = it?.get(position)
            it?.apply {
                removeAt(position)
                add(position.inc(), personTemp!!)
                list.value = this
            }
        }
    } else list.value
}

fun showViews(vararg views: View) {
    for (view in views) view.visibility = View.VISIBLE
}

fun hideViews(vararg views: View) {
    for (view in views) view.visibility = View.GONE
}

fun log(message: String) {
    Log.d("TAG", "log: $message")
}

fun createGradient(textView: TextView, colors: IntArray) {
    val paint = textView.paint
    val width = paint.measureText(textView.text.toString())
    val textShader: Shader =
        LinearGradient(0f, 0f, width, textView.textSize, colors, null, Shader.TileMode.REPEAT)
    textView.paint.shader = textShader
}

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()