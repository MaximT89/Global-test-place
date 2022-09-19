package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }

    private val timer = Timer(
        fullTime = 7,
        interval = 1,
        repeatCount = 2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnStop.setOnClickListener {
            timer.stopTimer(
                onStop = {
                    binding.textName.text = "0"
                }
            )
        }

        binding.btnStart.setOnClickListener {
            timer.startTimer(
                onTick = {
                    binding.textName.text = it.toString()
                },
                onFinish = {
                    Snackbar.make(
                        this,
                        binding.root,
                        "Таймер отработал",
                        Snackbar.LENGTH_LONG
                    ).show()
                },
                onAllRepeatStop = {
                    binding.textName.text = "Все иттерации завершены"
                })
        }

        binding.btnPause.setOnClickListener {
            timer.onPause(onPause = {
                Snackbar.make(
                    this,
                    binding.root,
                    "Таймер приостановлен",
                    Snackbar.LENGTH_LONG
                ).show()
            })
        }
    }
}

