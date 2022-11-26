package com.secondworld.globaltestproject.ui

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    var mediaPlayer1 : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        CoroutineScope(Dispatchers.IO).launch { }


        setContentView(binding.root)

    }

    fun changeSong(song : Int) {
        mediaPlayer1?.release()
        mediaPlayer1 = MediaPlayer.create(this,song)
        mediaPlayer1?.isLooping = true
        mediaPlayer1?.start()
    }
}

