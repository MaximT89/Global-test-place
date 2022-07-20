package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private var bindingFragment: FragmentFirstBinding? = null
    private val viewModel by viewModels<FirstViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        bindingFragment = binding

        binding.editFirst.doAfterTextChanged {
            if (!TextUtils.isEmpty(it)) {
                viewModel.saveScore(it.toString().toInt())
            } else {
                viewModel.saveScore(0)
            }
        }

        viewModel.score.observe(viewLifecycleOwner) {
            binding.textFirst.text = it.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}