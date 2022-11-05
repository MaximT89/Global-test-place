package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.os.PersistableBundle
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

