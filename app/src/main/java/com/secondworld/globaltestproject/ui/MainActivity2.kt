package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE){
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}