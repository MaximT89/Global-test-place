package com.secondworld.globaltestproject.ui.screens.listNote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListNotesFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    private val viewModel by viewModels<ListNoteViewModel>()
    private val adapter = NoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.listNote.observe(viewLifecycleOwner) {
            if (it != null) { adapter.items = it }
        }
    }

    private fun initView() {
        binding.recyclerView.adapter = adapter

        binding.btnCreateNote.setOnClickListener {
            viewModel.createNote()
        }

        adapter.callBack = { id ->
            setFragmentResult("key", bundleOf("id" to id))
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}