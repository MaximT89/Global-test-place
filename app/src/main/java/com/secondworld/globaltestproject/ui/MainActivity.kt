package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val userManager by lazy { UserManager(dataStore) }

    private fun saveData() {
        binding.btnSave.setOnClickListener {
            lifecycleScope.launch { userManager.storeUser(15) } }
    }

    private fun observeData() {
        lifecycleScope.launch {
            userManager.userAgeFlow.collect{
                if(it!=null){ binding.textTest1.text = it.toString() } }
        }
    }

    private val binding by lazy(LazyThreadSafetyMode.NONE) { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        saveData()
        observeData()
    }
}
