package com.secondworld.globaltestproject.core

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Resources
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

fun View.click(logic : () -> Unit) {
    setOnClickListener { logic.invoke() }
}

fun updateText(view: TextView, message: Any) {
    view.text = message.toString()
}

fun String.onlyDigits() : String {
    return filter { it.isDigit() }
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

fun log(message: String) {
    Log.d("TAG", "log: $message")
}

fun log(tag: String, message: String) {
    Log.d(tag, "log: $message")
}

fun Button.active(){
    isVisible = true
    isEnabled = true
    isClickable = true
}

fun Button.notActive(){
    isVisible = true
    isEnabled = false
    isClickable = false
}

fun <T>MutableLiveData<List<T>?>.newListMain(someLogic : (data : T) -> T) {
    value.let { items ->
        value = items?.map {
            someLogic.invoke(it)
        }
    }
}

fun <T>MutableLiveData<List<T>?>.newListIo(someLogic : (data : T) -> T) {
    postValue(value?.map {
        someLogic.invoke(it)
    })
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

fun Activity.snackbar(message: String) {
    Snackbar.make(this, findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
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

/**
 * Метод для запуска множества сетов с анимациями и с прослушиванием окончания последней анимации
 */
fun List<AnimatorSet>.playAllSets(coroutineScope: CoroutineScope, end: () -> Unit) {
    coroutineScope.launch(Dispatchers.Main) {
        for (animSet in this@playAllSets) {
            animSet.start()
            delay(animSet.duration)
        }
        delay(1500)
        end.invoke()
    }
}

/**
 * Метод для запуска одного сета с анимациями с прослушиванием окончания анимации
 */
fun AnimatorSet.playSingleSet(end: () -> Unit) {
    start()
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            super.onAnimationEnd(animation)
            end.invoke()
        }
    })
}

/**
 * Метод для запуска одного сета с анимациями без прослушивания окончания анимации
 */
fun AnimatorSet.playSingleSet() {
    start()
}

fun String.upperFirst() = substring(0, 1).uppercase() + drop(1)

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

/**
 * Метод для конверта UNIX_time в классическую строку времени
 */
@SuppressLint("SimpleDateFormat")
fun Long.convertToDate() : String{
    val date = Date(this * 1000L)
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(date)
}

/**
 * Метод для чтения из префов
 */
fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) =
    edit().also(operation).apply()

/**
 * Метод для записи в префы
 */
fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
    val key = pair.first
    when (val value = pair.second) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        else -> error("Only primitive types can be stored in SharedPreferences")
    }
}


fun isRefreshingFalse(view: SwipeRefreshLayout){
    view.isRefreshing = false
}

fun isRefreshingTrue(view: SwipeRefreshLayout){
    view.isRefreshing = true
}