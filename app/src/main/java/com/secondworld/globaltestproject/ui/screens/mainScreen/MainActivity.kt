package com.secondworld.globaltestproject.ui.screens.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
    }

    private fun initObservers() {
        viewModel.observe(this){
            val sb = StringBuilder()
            for(user in it){
                sb.append(user.name).append("\n\n")
            }
            binding.textTest1.text = sb.toString()
        }
    }
}