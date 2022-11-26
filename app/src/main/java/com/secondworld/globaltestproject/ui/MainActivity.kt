package com.secondworld.globaltestproject.ui

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initObservers() {

    }

    override fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController

        binding.bottomNavView.setupWithNavController(navController)
    }

}

