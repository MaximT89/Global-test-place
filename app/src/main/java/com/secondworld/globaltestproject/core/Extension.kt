package com.secondworld.globaltestproject.core

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.res.Resources
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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



fun showViews(vararg views: View) {
    for (view in views) view.visibility = View.VISIBLE
}

fun hideViews(vararg views: View) {
    for (view in views) view.visibility = View.GONE
}

fun log(message : Any){
    Log.d("TAG", "log: ${message.toString()}")
}

fun createGradient(textView: TextView, colors: IntArray) {
    val paint = textView.paint
    val width = paint.measureText(textView.text.toString())
    val textShader: Shader = LinearGradient(0f, 0f, width, textView.textSize, colors, null, Shader.TileMode.REPEAT)

    textView.paint.shader = textShader
}

fun Int.toDp() : Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun String.upperFirst() = this.substring(0, 1).uppercase() + this.drop(1)

// Удаление элемента по позиции из liveData
fun <T> removeItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    list.value.apply {
        this?.removeAt(position)
        list.value = this
    }
}





// Переместить элемент вверх в recyclerView (listView)
fun <T> upItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    if (position != 0){
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

fun Activity.snackbar(message: String) {
    Snackbar.make(this, findViewById(android.R.id.content) , message, Snackbar.LENGTH_LONG ).show()
}

fun View.animateLikeButton() {
    setOnClickListener {
        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(it, View.SCALE_X, 1f, 0.95f, 1f),
                ObjectAnimator.ofFloat(it, View.SCALE_Y, 1f, 0.95f, 1f)
            )
            duration = 100
            start()
        }
    }
}

// Переместить элемент вниз в recyclerView (listView)
fun <T> downItem(position: Int, list: MutableLiveData<MutableList<T>?>) {
    if (position != list.value?.size?.minus(1)){
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

fun List<AnimatorSet>.playAllSets(coroutineScope: CoroutineScope, end : () -> Unit){
    coroutineScope.launch(Dispatchers.Main){
        for(animSet in this@playAllSets){
            animSet.start()
            delay(animSet.duration)
        }
        end.invoke()
    }
}