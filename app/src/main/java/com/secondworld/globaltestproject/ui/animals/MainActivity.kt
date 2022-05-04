package com.secondworld.globaltestproject.ui.animals

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.launchWhenStarted
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

const val TAG = "TAG"

@SuppressLint("ShowToast")
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()
    private val animalAdapter = AnimalAdapter()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initObservers() {
        viewModel.state.onEach {
            when(it){
                is MainActivityState.Error -> Snackbar.make(this, binding.root, it.error, Snackbar.LENGTH_LONG)
                is MainActivityState.Init -> Snackbar.make(this, binding.root, "Стартанули", Snackbar.LENGTH_LONG)
                is MainActivityState.IsLoading -> {
                    if(it.isLoading){
                        binding.shimmerViewContainer.isVisible = true
                        binding.recyclerView.isGone = true
                    } else{
                        binding.recyclerView.isVisible = true
                        binding.shimmerViewContainer.isGone = true
                    }
                }
                is MainActivityState.Success -> {
                    animalAdapter.items = it.data
                }
            }
        }.launchWhenStarted(lifecycleScope)
    }

    override fun initView() {
        binding.shimmerViewContainer.startShimmerAnimation()
        binding.recyclerView.adapter = animalAdapter
    }
}