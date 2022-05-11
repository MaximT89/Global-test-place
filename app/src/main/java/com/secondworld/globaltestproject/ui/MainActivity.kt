package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.ui.Lists.list1
import com.secondworld.globaltestproject.ui.Lists.list2
import com.secondworld.globaltestproject.ui.Lists.list3
import com.secondworld.globaltestproject.ui.Lists.list4
import com.secondworld.globaltestproject.ui.Lists.list5

class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val rootAdapter = RootAdapter(this)
        binding.rvRoot.adapter = rootAdapter

        rootAdapter.itemsRoot = listOf(
            list1,
            list2,
            list3,
            list4,
            list5
        )
    }
}
