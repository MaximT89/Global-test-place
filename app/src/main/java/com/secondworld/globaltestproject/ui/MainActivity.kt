package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.ui.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var storageName: StorageName


    @Inject
    lateinit var repository: RepositoryImpl
    private var viewPagerAdapter: ViewPagerAdapter? = null
    private val maxState = 3
    private var myState = 0
    private var currentPosition = 0

    private val TIME_VALUE = 4000

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        timer()


    }

    fun timer() {
        object : CountDownTimer(TIME_VALUE.toLong(), 5) {
            override fun onTick(value: Long) {
                val i = TIME_VALUE - value
                binding.progressBar.progress = i.toInt()
            }

            override fun onFinish() {
                timer()
                binding.viewPager.setCurrentItem(nextPage(currentPosition), true)
                log(currentPosition)
            }
        }.start()
    }

    fun nextPage(position: Int): Int {
        val page = position + 1
        return if (page > maxState - 1) {
            0
        } else {
            page
        }

    }

    private fun initView() {
        binding.progressBar.max = TIME_VALUE

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "First"
                }
                1 -> {
                    tab.text = "Second"
                }
                2 -> {
                    tab.text = "Third"
                }
            }
        }.attach()

        onInfinitePageChangeCallback(maxState)
    }

    private fun onInfinitePageChangeCallback(listSize: Int) {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrollStateChanged(state: Int) {
                myState = state
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                currentPosition = position
                super.onPageSelected(position)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
                if (myState == ViewPager2.SCROLL_STATE_DRAGGING && currentPosition == position && currentPosition == 0)
                    binding.viewPager.setCurrentItem(2, true)
                else if (myState == ViewPager2.SCROLL_STATE_DRAGGING && currentPosition == position && currentPosition == 2)
                    binding.viewPager.setCurrentItem(0, true)

                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })
    }
}

