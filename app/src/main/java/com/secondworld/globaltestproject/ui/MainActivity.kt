package com.secondworld.globaltestproject.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.data.activity.ActivityRepository
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var repository: ActivityRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(!viewModel.statusLoadStartFragment.value!!){
            viewModel.statusLoadStartFragment.value = true

//            val navController = findNavController(R.id.nav_host_fragment)

//            Navigation.setViewNavController(binding.root, navController)
//                binding.root.setOnClickListener{
//                    it.findNavController().navigate(getLastFragment())
//                }
        }
    }

    fun saveLastFragment(value : CharSequence){
        repository.saveLastFragment(value.toString())
    }

    fun getLastFragment() : Int = repository.loadLastFragment()

}