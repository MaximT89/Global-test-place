package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var bindingFragment: FragmentSecondBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecondBinding.bind(view)
        bindingFragment = binding

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment,
                null,
                navOptions {
                    anim {
                        enter = R.anim.slide_in_left
                        exit  = R.anim.slide_in_right
                        popEnter = R.anim.slide_in_left_pop
                        popExit  = R.anim.slide_in_right_pop
                    }
                })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}