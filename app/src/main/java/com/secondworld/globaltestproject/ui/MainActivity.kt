package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.secondworld.globaltestproject.data.activity.ActivityRepository
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var repository: ActivityRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun saveLastFragment(value : CharSequence){
        repository.saveLastFragment(value.toString())
    }

    fun getLastFragment() : Int = repository.loadLastFragment()

}