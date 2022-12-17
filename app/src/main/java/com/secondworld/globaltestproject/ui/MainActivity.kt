package com.secondworld.globaltestproject.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.log
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

        binding.bottomNavView.menu.findItem(R.id.mainScreenFragment).icon =  getLottieDrawable(
            context = this,
            rawRes = R.raw.instagram
        )

        binding.bottomNavView.setOnItemSelectedListener { item ->
            getIconDrawable(item.icon)
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

    @SuppressLint("Recycle")
    private fun getIconDrawable(icon: Drawable): Boolean{
        val lottie = icon as? LottieDrawable
        lottie?.playAnimation()
        return true
    }

}

