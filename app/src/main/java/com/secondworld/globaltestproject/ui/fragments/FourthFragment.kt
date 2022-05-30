package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentFourthBinding

class FourthFragment : Fragment(R.layout.fragment_fourth) {

    private var bindingFragment: FragmentFourthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFourthBinding.bind(view)
        bindingFragment = binding
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}