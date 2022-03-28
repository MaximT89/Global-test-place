package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.createGradient
import com.secondworld.globaltestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textTest1.text = "HELLO MY FRIEND"

        createGradient(binding.textTest1, intArrayOf(
            resources.getColor(R.color.orange_red),
            resources.getColor(R.color.coral),
            resources.getColor(R.color.blue_violet)
        ))

        binding.textTest2.text = "HELLO MY FRIEND"

        createGradient(binding.textTest2, intArrayOf(
            R.color.orange_red,
            R.color.coral,
            R.color.blue_violet
        ))


    }

}