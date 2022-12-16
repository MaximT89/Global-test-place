package com.secondworld.globaltestproject.ui.screens.first

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.screens.first.Operation.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding) {
        editText.addTextChangedListener(MyTextWatcher(editText))

        startPlus.click { viewModel.updateStartValue(PLUS) }
        startMinus.click { viewModel.updateStartValue(MINUS) }

        endPlus.click { viewModel.updateEndValue(PLUS) }
        endMinus.click { viewModel.updateEndValue(MINUS) }

    }

    override fun initObservers() = with(viewModel){

        startValue.observe {
            binding.editText.hint = viewModel.updateHint()
            binding.startValueText.text = it.toString()
            validateEditText()
        }

        endValue.observe {
            binding.editText.hint = viewModel.updateHint()
            binding.endValueText.text = it.toString()
            validateEditText()
        }
    }

    private fun validateEditText() {
        if (!TextUtils.isEmpty(binding.editText.text) && (binding.editText.text.toString() != "") && (binding.editText.text.toString() != "-")) {
            log("work1")
            if (binding.editText.text.toString().toInt() > viewModel.getEndValue()!!) {
                log("work2")
                binding.editText.setText(viewModel.getEndValue()!!.toString())
            }
            if (binding.editText.text.toString().toInt() < viewModel.getStartValue()!!) {
                log("work3")
                binding.editText.setText(viewModel.getStartValue()!!.toString())
            }
        }
    }

    inner class MyTextWatcher(private val editText: EditText) : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun afterTextChanged(input: Editable?) {

            try {
                editText.removeTextChangedListener(this)

                if (input?.length!! >= 2 && input.startsWith("0"))
                    editText.setText("")

                if (input.toString().toInt() > viewModel.getEndValue()!!)
                    editText.setText(viewModel.getEndValue().toString())

                if (input.toString().toInt() < viewModel.getStartValue()!!)
                    editText.setText(viewModel.getStartValue().toString())

            } catch (e: Exception) {
                editText.setText("0")
            } finally {
                editText.setSelection(editText.length())
                editText.addTextChangedListener(this)
            }
        }
    }


}