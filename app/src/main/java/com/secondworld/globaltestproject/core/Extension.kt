package com.secondworld.globaltestproject.core

import android.content.res.Resources
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.secondworld.globaltestproject.data.models.Person

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

fun <T>MutableLiveData<List<T>?>.newList(someLogic : (data : T) -> T) {
    value.let { items ->
        value = items?.map {
            someLogic.invoke(it)
        }
    }
}

// Удаление элемента по позиции из liveData
fun <T> removeItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    list.value?.apply {
        removeAt(position)
        list.value = this
    }
}

// Переместить элемент вверх в recyclerView (list adapter)
fun <T> upItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    if (position != 0) {
        list.value?.apply {
            removeAt(position)
            add(position.dec(), this[position])
            list.value = this
        }
    }
}

// Переместить элемент вниз в recyclerView (listView)
fun <T> downItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    if (position != list.value?.size?.minus(1)) {
        list.value?.apply {
            removeAt(position)
            add(position.inc(), this[position])
            list.value = this
        }
    }
}



inline fun <reified T>MutableLiveData<List<T>?>.newList() {
    value.let { items ->
        value = items?.map {
            val method = T::class.javaClass.getDeclaredMethod("copy")
            method.isAccessible = true
            method.invoke(it) as T
        }
    }
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