package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private var bindingFragment: FragmentThirdBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentThirdBinding.bind(view)
        bindingFragment = binding

        binding.btnNext.setOnClickListener {

            findNavController().navigate(
                R.id.action_thirdFragment_to_firstFragment,
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
