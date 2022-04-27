package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@SuppressLint("NotifyDataSetChanged")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewPagerAdapter: ViewPagerAdapter? = null
    private var list = mutableListOf<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (list.size == 0) list.add(BlankFragment.newInstance())

        initViewPager()
    }

    fun currentPosition() = binding.viewPager.currentItem

    fun addPage() {
        list.add(BlankFragment.newInstance())
        viewPagerAdapter?.notifyDataSetChanged()
    }

    fun removePage() {
        if(list.size > 1) list.removeLast()
        viewPagerAdapter?.notifyDataSetChanged()
    }

    private fun initViewPager() {
        viewPagerAdapter = ViewPagerAdapter(this, list)
        binding.viewPager.adapter = viewPagerAdapter
    }
}

