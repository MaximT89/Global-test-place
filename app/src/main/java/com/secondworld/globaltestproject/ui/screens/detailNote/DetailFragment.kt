package com.secondworld.globaltestproject.ui.screens.detailNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.updateText
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("key") { _, bundle ->
            val result = bundle.getInt("id")
            viewModel.getNote(result)
        }

        initObservers()
    }

    private fun initObservers() {
        viewModel.note.observe(viewLifecycleOwner){
            binding.textNote.text = it?.note
        }
    }
}