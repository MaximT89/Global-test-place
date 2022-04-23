package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.updateText
import com.secondworld.globaltestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    private var timer: CountDownTimer? = null
    private var durationTrack: Int? = null
    private var startSeekPosition: Int = 0

    @SuppressLint("SetTextI18n", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    @SuppressLint("NewApi")
    private fun initView() {

        binding.btnStart.setOnClickListener {
            startPlayMusic()
        }

        binding.btnStop.setOnClickListener {
            stopPlayMusic()
        }
    }

    private fun stopPlayMusic() {

        updateText(binding.textCurrentDuration, "0 : 00")
        binding.seekBar.progress = 0

        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.release()
            mediaPlayer = null
            timer?.cancel()
            timer = null
            startSeekPosition = 0
        }
    }

    private fun startPlayMusic() {
        if (mediaPlayer != null) {
            if (mediaPlayer?.isPlaying == true) {
                stopPlayMusic()
            }
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.bird)
        mediaPlayer?.start()
        durationTrack = mediaPlayer?.duration

        binding.seekBar.max = durationTrack!! / 1000
        startTimer(durationTrack)

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (mediaPlayer != null) {
                    startSeekPosition = seekBar!!.progress
                    updateMediaPlayer(seekBar.progress * 1000)
                }
            }
        })
    }

    private fun updateMediaPlayer(progress: Int) {
        mediaPlayer?.seekTo(progress)
        startTimer(durationTrack!! - progress)
    }

    private fun startTimer(duration: Int?) {

        timer?.cancel()
        timer = null

        if (duration != null) {
            timer = object : CountDownTimer(duration.toLong(), 1000) {
                override fun onTick(value: Long) {
                    updateProgressBar(startSeekPosition + duration / 1000 - value.toInt() / 1000)
                    updateText(binding.textCurrentDuration, secondsToMin((value / 1000).toInt()))
                }

                override fun onFinish() {
                    stopPlayMusic()
                    binding.seekBar.progress = 0
                    startSeekPosition = 0
                }
            }.start()
        }
    }


    fun updateProgressBar(seconds: Int) {
        binding.seekBar.progress = seconds
    }

    fun secondsToMin(seconds: Int): String {
        val sec = seconds % 60
        val s = if (sec < 10) "0$sec"
        else "$sec"
        return "${seconds / 60} : $s"
    }
}
