package com.secondworld.globaltestproject.ui

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import kotlin.math.abs

class Timer(
    private val fullTime: Long,
    private val interval: Long,
    private val repeatCount: Int = 1
) {
    private var timer: CountDownTimer? = null
    private var currentSecond = MutableLiveData(fullTime)
    private var repeat = MutableLiveData(abs(repeatCount))

    fun startTimer(
        onTick: (Long) -> Unit = {},
        onFinish: () -> Unit = {},
        onAllRepeatStop: () -> Unit = {}
    ) {

        timer = object : CountDownTimer(
            currentSecond.value?.times(1000)!!,
            interval * 1000
        ) {
            override fun onTick(p0: Long) {
                currentSecond.value = currentSecond.value!!.minus(1)
                onTick.invoke(p0 / 1000)
            }

            override fun onFinish() {
                repeat.value = repeat.value?.minus(1)
                currentSecond.value = fullTime
                if (repeat.value != 0) {
                    startTimer(onTick, onFinish, onAllRepeatStop)
                } else {
                    repeat.value = repeatCount
                    onAllRepeatStop.invoke()
                }
                onFinish.invoke()
            }
        }.start()
    }

    fun stopTimer(onStop: () -> Unit = {}) {
        repeat.value = repeatCount
        currentSecond.value = fullTime
        timer?.cancel()
        timer = null
        onStop.invoke()
    }

    fun onPause(onPause : () -> Unit = {}) {
        if (timer != null) {
            timer?.cancel()
            onPause.invoke()
        }
    }
}