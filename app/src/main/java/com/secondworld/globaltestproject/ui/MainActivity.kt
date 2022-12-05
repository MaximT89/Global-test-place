package com.secondworld.globaltestproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_FADE
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_SLIDE
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.core.snackbar
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}

