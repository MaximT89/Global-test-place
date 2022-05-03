package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.models.Animals
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var sb: StringBuilder? = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        lifecycleScope.launchWhenStarted {

            viewModel.animals.collect { animals ->
                animals.forEach {
                    when (it) {
                        is Animals.Bird -> updateText(it.name)
                        is Animals.Cat -> updateText(it.name)
                        is Animals.Dog -> updateText(it.name)
                    }
                }
                up(sb.toString())
            }
        }
    }

    private fun up(s: String) {binding.textName.text = s}


    private fun updateText(name: String) = sb?.append(name)?.append("\n")
}