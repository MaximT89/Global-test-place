package com.secondworld.globaltestproject.ui.screens

import android.content.Context
import androidx.activity.OnBackPressedCallback
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.databinding.FragmentFouthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FourthFragment : BaseFragment<FragmentFouthBinding>(FragmentFouthBinding::inflate) {
    override fun initView() = with(binding) {

        btnGoThird.click {
            navigateTo(R.id.thirdFragment)
        }

        customBackPressed(needCustomNavigate = true, resId = R.id.secondFragment)
    }

    override fun initObservers() {
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                log(tag = "b_press", message = "work work work")
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,  // LifecycleOwner
            callback
        )
    }

}