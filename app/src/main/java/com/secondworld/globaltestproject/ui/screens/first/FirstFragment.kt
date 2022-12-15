package com.secondworld.globaltestproject.ui.screens.first

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding

class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding) {

        testBtn.click {
            Toast.makeText(requireActivity(), "текст", Toast.LENGTH_LONG).show()
        }
    }

    override fun initObservers() {
    }


}