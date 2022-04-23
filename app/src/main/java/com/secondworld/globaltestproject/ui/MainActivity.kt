package com.secondworld.globaltestproject.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.updateText
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.models.Animals
import com.secondworld.globaltestproject.domain.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storageName = StorageName()
    private val repository: Repository = RepositoryImpl(storageName)
    private var mediaPlayer: MediaPlayer? = null

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
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    private fun startPlayMusic() {

//        if(mediaPlayer != null){
//            if(mediaPlayer?.isPlaying == true){
//                stopPlayMusic()
//            }
//        }

        mediaPlayer = MediaPlayer.create(this, R.raw.bird)
        mediaPlayer?.prepare()
        mediaPlayer?.start()

    }
}

