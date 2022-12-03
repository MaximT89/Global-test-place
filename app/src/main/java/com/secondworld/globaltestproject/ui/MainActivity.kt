package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.data.Profession
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    // test
    // test2
    // test3

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private var personAdapter : PersonsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()
    }

    private fun initObservers() = with(viewModel) {

        listPersons.observe { personAdapter?.submitList(it) }

        filterChips.observe { if (getFilterStart()) personAdapter?.submitList(filterData(it)) }

        listChips.observe { createChips(it) }
    }

    private fun createChips(listChips: List<Profession>?) {
        listChips?.forEach { profession ->
            val chipDrawable = ChipDrawable.createFromAttributes(
                this,
                null,
                0,
                com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
            )
            Chip(this).apply{
                setChipDrawable(chipDrawable)
                text = profession.ru
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        viewModel.filterStartUpdate(true)
                        viewModel.updateCurrentChips(profession, true)
                    } else viewModel.updateCurrentChips(profession, false)
                }
                binding.chips.addView(this as View)
            }
        }
    }

    private fun initView() {
        personAdapter = PersonsAdapter()
        binding.recyclerView.adapter = personAdapter
    }
}

