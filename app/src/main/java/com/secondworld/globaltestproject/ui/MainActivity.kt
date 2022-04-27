package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun initView() {
        binding.textTest.text = "Foo"
    }

    override fun initObservers() {

    }
}

