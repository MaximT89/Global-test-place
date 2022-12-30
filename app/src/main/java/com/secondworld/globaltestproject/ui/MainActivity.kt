package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseActivity
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.root_app_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.let { binding.bottomNavView.setSetupWithNavController(it) }
    }
}

fun BottomNavigationView.setSetupWithNavController(navController: NavController?) {
    navController?.let {
        setupWithNavController(it)
    }
    setOnItemSelectedListener { menuItem ->
        val builder = NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(true)
        val graph = navController?.currentDestination?.parent
        val destination = graph?.findNode(menuItem.itemId)
        if (menuItem.order and Menu.CATEGORY_SECONDARY == 0) {
            navController?.graph?.findStartDestination()?.id?.let {
                builder.setPopUpTo(
                    it,
                    inclusive = false,
                    saveState = true
                )
            }
        }
        val options = builder.build()
        destination?.id?.let { id -> navController.navigate(id, null, options) }
        return@setOnItemSelectedListener true
    }
}

