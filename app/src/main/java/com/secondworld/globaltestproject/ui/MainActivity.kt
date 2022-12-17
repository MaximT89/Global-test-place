package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
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
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController

        binding.bottomNavView.setupWithNavController(navController)

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.mainScreenFragment -> navController.navigate(R.id.mainScreenFragment)
                R.id.searchScreenFragment -> navController.navigate(R.id.searchScreenFragment)
                R.id.favouriteScreenFragment -> navController.navigate(R.id.favouriteScreenFragment)
            }

            true

        }


        binding.bottomNavView.menu.findItem(R.id.mainScreenFragment).icon = getLottieDrawable(
            context = this,
            rawRes = R.raw.instagram
        )

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when(destination.label) {
                "fragment_main_screen" -> {
                    val lottie = binding.bottomNavView.menu.findItem(R.id.mainScreenFragment).icon as LottieDrawable
                    lottie.playAnimation()
                }
            }
        }


//        binding.bottomNavView.setOnItemSelectedListener { item ->
//
//            getIconDrawable(item.icon)
//        }

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

//    @SuppressLint("Recycle")
//    private fun getIconDrawable(icon: Drawable): Boolean{
//        val lottie = icon as? LottieDrawable
//        lottie?.playAnimation()
//        return true
//    }

}

