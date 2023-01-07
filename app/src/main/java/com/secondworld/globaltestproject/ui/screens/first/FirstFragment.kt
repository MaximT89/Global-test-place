package com.secondworld.globaltestproject.ui.screens.first


import android.graphics.Typeface
import android.text.*
import android.text.style.MetricAffectingSpan
import android.widget.Toast
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.getColor
import com.secondworld.globaltestproject.core.extension.toast
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    override fun initView() {
        binding.btnTest.click {
            "hello".toast(Toast.LENGTH_LONG)
        }

    }

    override fun initObservers() = Unit

}




open class CustomTypefaceSpan(private val font: Typeface?) : MetricAffectingSpan() {

    override fun updateMeasureState(textPaint: TextPaint) = update(textPaint)

    override fun updateDrawState(textPaint: TextPaint) = update(textPaint)

    private fun update(textPaint: TextPaint) {
        textPaint.apply {
            val old = typeface
            val oldStyle = old?.style ?: 0
            val font = Typeface.create(font, oldStyle)
            typeface = font
        }
    }
}




