package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.core.dataStore
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val userManager by lazy {
        UserManager(dataStore)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        saveData()
        observeData()
    }

    private fun saveData() {
        binding.btnSave.setOnClickListener {
            lifecycleScope.launch {
                userManager.storeUser(15, "Max", "John", true)
            }
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            userManager.userAgeFlow.asLiveData().observe(this@MainActivity){
                if(it!=null){
                    binding.textTest1.text = it.toString()
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            userManager.userFirstNameFlow.collect {
                if(it != null){
                    binding.textTest2.text = it
                }
            }
        }
    }
}
