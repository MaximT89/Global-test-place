package com.secondworld.globaltestproject.ui

import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.launchWhenStarted
import com.secondworld.globaltestproject.data.ApiResult
import com.secondworld.globaltestproject.data.ResponseFox
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.onEach
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initObservers() {
        viewModel.data.onEach {
            when(it){
                is ApiResult.Empty -> println("Nothing")
                is ApiResult.Error -> println(it.message)
                is ApiResult.Success<*> -> {
                    val data = it.data as Response<ResponseFox>
                    val body = data.body()

                    binding.imgTest.load(body?.image) {
                        crossfade(true)
                        placeholder(R.drawable.placeholder)
                    }
                }
            }
        }.launchWhenStarted(lifecycleScope)
    }

    override fun initView() {
        binding.btnGetData.setOnClickListener { viewModel.fetchData() }
    }

}

