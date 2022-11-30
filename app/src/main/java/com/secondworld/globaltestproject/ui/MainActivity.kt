package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.ui.model.PersonItem
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val personAdapter = PersonsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()
    }


    private fun initObservers() {
        viewModel.listPersons.observe(this) { list ->
            personAdapter.submitList(list)
        }

        viewModel.filterChips.observe(this){ listProfessional ->
            personAdapter.submitList(viewModel.filterData(listProfessional))
        }

        viewModel.listChips.observe(this) { listChips ->

            listChips.forEach { profession ->
                val chip = Chip(this)
                val chipDrawable = ChipDrawable.createFromAttributes(
                    this,
                    null,
                    0,
                    com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
                )
                chip.setChipDrawable(chipDrawable)
                chip.text = profession.ru
                chip.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) viewModel.updateCurrentChips(profession, true)
                    else viewModel.updateCurrentChips(profession, false)
                }
                binding.chips.addView(chip as View)
            }
        }
    }

    private fun initView() {
        binding.recyclerView.adapter = personAdapter
    }
}

