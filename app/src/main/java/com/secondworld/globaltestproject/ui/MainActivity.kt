package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.core.snackbar
import com.secondworld.globaltestproject.data.api.RetrofitClient
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            try {
                val responseMemes = RetrofitClient.getApiService().getMemes()

                withContext(Dispatchers.Main) {
                    binding.textTest.text = responseMemes.data?.memes?.get(1)?.id
                }
            } catch (e: Exception) {
                snackbar("неудачный запрос")
            }
        }
    }
}