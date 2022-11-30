package com.secondworld.globaltestproject.core

import android.os.Build
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Проверяем, если у нас отображается клавиатура, то при клике вне клавиатуры мы вызываем метод
     * [hideKeyboard] , которым скрываем клавиатуру
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
    }
}