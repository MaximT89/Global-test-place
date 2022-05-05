package com.secondworld.globaltestproject.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.databinding.FragmentSixthBinding


class SixthFragment : Fragment(R.layout.fragment_sixth) {

    private var bindingFragment: FragmentSixthBinding? = null

    @SuppressLint("Recycle")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSixthBinding.bind(view)
        bindingFragment = binding




    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }

}