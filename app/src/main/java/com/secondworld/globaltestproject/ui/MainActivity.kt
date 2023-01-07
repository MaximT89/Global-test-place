package com.secondworld.globaltestproject.ui

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initObservers() = Unit

    override fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.let { binding.bottomNavView.setSetupWithNavController(it) }

        binding.bottomNavView.menu.findItem(R.id.mainScreenFragment).icon = getLottieDrawable(
            context = this,
            rawRes = R.raw.instagram
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.label) {
                "fragment_main_screen" -> {
                    val lottie =
                        binding.bottomNavView.menu.findItem(R.id.mainScreenFragment).icon as LottieDrawable
                    lottie.playAnimation()
                }
            }
        }
    }

    private fun getLottieDrawable(context: Context?, rawRes: Int): LottieDrawable {
        return LottieDrawable().apply {
            val result = LottieCompositionFactory.fromRawResSync(
                context,
                rawRes
            )
            composition = result.value
        }
    }
}

fun BottomNavigationView.setSetupWithNavController(navController: NavController?) {
    navController?.let {
        setupWithNavController(it)
    }
    setOnItemSelectedListener { menuItem ->
        val builder = NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(false)
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