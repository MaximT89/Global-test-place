package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentFifthBinding

class FifthFragment : Fragment(R.layout.fragment_fifth) {

    private var bindingFragment: FragmentFifthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFifthBinding.bind(view)
        bindingFragment = binding

        binding.btnNext.setOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment2).navigate(R.id.action_fifthFragment_to_sixthFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }

}