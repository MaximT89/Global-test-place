package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.Navigator
import com.secondworld.globaltestproject.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            navigate(Navigator.TO_FOURTH)
        }
    }
}
