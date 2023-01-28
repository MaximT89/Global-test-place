package com.secondworld.globaltestproject.ui

import android.R
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.bases.BaseActivity
import com.secondworld.globaltestproject.core.extension.showSnackbar
import com.secondworld.globaltestproject.core.extension.toast
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    fun hello(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("TAG1", "onCreate: ")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        showSnackbar("Some text")
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}



