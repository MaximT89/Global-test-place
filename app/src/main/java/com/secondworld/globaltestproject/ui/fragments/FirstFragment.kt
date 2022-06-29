package com.secondworld.globaltestproject.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.animateLikeButton
import com.secondworld.globaltestproject.data.Person
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var bindingFragment: FragmentFirstBinding? = null

    @SuppressLint("Recycle")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        bindingFragment = binding

        binding.btnNext.setOnClickListener {

            setFragmentResult("key1", bundleOf(
                "data1" to "Max",
                "data2" to Person("Tom"),
                "data3" to 15
            ))

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.textShadow.animateLikeButton()
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}