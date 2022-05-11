package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.updateText
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        initView()
    }

    private fun initView() {
        binding.refreshData.setOnClickListener {
            viewModel.refreshData()
        }
    }

    private fun initObservers() {

        with(viewModel) {
            userActions.observe(this@MainActivity) {
                updateText(binding.userActions, it.actions)
            }

            userInfo.observe(this@MainActivity) {
                updateText(binding.userName, it.name)
                updateText(binding.userAge, it.age)
                updateText(binding.userBonus, it.bonuses)
            }

            userOffers.observe(this@MainActivity) {
                updateText(binding.userOffers, convertSbToString(it.offers))
            }
        }
    }

    private fun convertSbToString(offers: MutableList<String>) =
        StringBuilder().apply {
            offers.forEach { s ->
                this.append(s)
                this.append("\n\n")
            }
        }.toString()

}


