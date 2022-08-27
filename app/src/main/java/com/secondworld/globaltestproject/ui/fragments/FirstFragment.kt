package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.Navigator
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        // new example
//        binding.btnNext.setOnClickListener {
//            navigate(Navigator.TO_SECOND)
//        }

        // old example
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment,
                null,
                navOptions {
                    anim {
                        enter = R.anim.slide_enter_mts

                    }
                })
        }
    }
}