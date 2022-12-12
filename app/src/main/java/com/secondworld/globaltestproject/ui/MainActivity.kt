package com.secondworld.globaltestproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseActivity
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController


        navController.addOnDestinationChangedListener { _, destination, _ ->
            updateBottomPanel(destination.label.toString())
        }
    }

    private fun updateBottomPanel(label: String) {
        when (label) {
            "fragment_first" -> {
                binding.currentScreen.text = "Избранное"
                binding.imgFavourite.setColorFilter(ContextCompat.getColor(this, R.color.red))
                binding.imgPerson.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imgWork.setColorFilter(ContextCompat.getColor(this, R.color.white))

            }
            "fragment_second" -> {

                binding.currentScreen.text = "Профиль"
                binding.imgFavourite.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imgPerson.setColorFilter(ContextCompat.getColor(this, R.color.red))
                binding.imgWork.setColorFilter(ContextCompat.getColor(this, R.color.white))

            }
            "fragment_third" -> {

                binding.currentScreen.text = "Работа"
                binding.imgFavourite.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imgPerson.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imgWork.setColorFilter(ContextCompat.getColor(this, R.color.red))

            }

        }
    }
}

