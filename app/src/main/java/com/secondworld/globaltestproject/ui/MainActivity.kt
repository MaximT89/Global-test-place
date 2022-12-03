package com.secondworld.globaltestproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBarChart.click {
            startActivity(Intent(this, BarChartActivity::class.java))
        }

    }
}

