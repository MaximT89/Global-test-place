package com.secondworld.globaltestproject.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {

    private val binding: ActivityBarChartBinding by lazy {
        ActivityBarChartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list: MutableList<BarEntry> = mutableListOf()
        list.add(BarEntry(2014f, 420f))
        list.add(BarEntry(2015f, 475f))
        list.add(BarEntry(2016f, 508f))
        list.add(BarEntry(2017f, 660f))
        list.add(BarEntry(2018f, 550f))
        list.add(BarEntry(2019f, 630f))
        list.add(BarEntry(2020f, 470f))

        val barDataSet = BarDataSet(list, "Visitors")
        barDataSet.setColors(
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.maroon),
                ContextCompat.getColor(this, R.color.Navy),
        )
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        val barData = BarData(barDataSet)
        binding.barChart.setFitBars(true)
        binding.barChart.data = barData
        binding.barChart.description.text = "Bar chart example"
        binding.barChart.animateY(2000)
    }
}