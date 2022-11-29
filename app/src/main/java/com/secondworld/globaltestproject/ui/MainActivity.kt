package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var adapterPizza : RecyclerPizzaAdapter? = null

    private  val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        initObservable()
    }

    private fun initObservable() {
        viewModel.listData.observe(this){ items ->
            adapterPizza?.items = items
        }
    }

    private fun initView() = with(binding){

        adapterPizza = RecyclerPizzaAdapter()

        viewPagerImageSlider.apply {
            adapter = adapterPizza
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(30))
        transformer.addTransformer { page, position ->
            val r : Float = 1 - Math.abs(position)
            page.scaleY =  0.85f + r * 0.15f
        }

        viewPagerImageSlider.setPageTransformer(transformer)

        dotsIndicator.attachTo(viewPagerImageSlider)
    }
}

