package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import android.widget.SeekBar
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.screens.first.Operation.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun initView() = with(binding) {
        startPlus.click { viewModel.updateStartValue(PLUS) }
        startMinus.click { viewModel.updateStartValue(MINUS) }

        endPlus.click { viewModel.updateEndValue(PLUS) }
        endMinus.click { viewModel.updateEndValue(MINUS) }

        editText.click { clipToBuffer(editText.text.toString()) }
        btnClipToBuffer.click { clipToBuffer(editText.text.toString()) }

        btnSave.click { mainValueText.text = "Main value : ${editText.text}" }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                editText.setText(p1.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) = Unit
            override fun onStopTrackingTouch(p0: SeekBar?) = Unit
        })
    }

    @SuppressLint("NewApi")
    override fun initObservers() = with(viewModel) {

        startValue.observe {
            binding.editText.hint = viewModel.updateHint()
            binding.startValueText.text = it.toString()
            binding.seekbar.min = it
        }

        endValue.observe {
            binding.editText.hint = viewModel.updateHint()
            binding.endValueText.text = it.toString()
            binding.seekbar.max = it
        }
    }
}