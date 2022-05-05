package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentSixthBinding

class SixthFragment : Fragment(R.layout.fragment_sixth) {

    private var bindingFragment: FragmentSixthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSixthBinding.bind(view)
        bindingFragment = binding

        binding.btnNext.setOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(R.id.firstFragment)
        }

        binding.btnNext2.setOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment2).navigate(R.id.fifthFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }

}