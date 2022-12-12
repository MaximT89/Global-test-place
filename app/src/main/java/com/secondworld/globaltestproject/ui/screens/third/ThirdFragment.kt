package com.secondworld.globaltestproject.ui.screens.third

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : BaseFragment<FragmentThirdBinding, ThirdViewModel>(FragmentThirdBinding::inflate) {
    override val viewModel: ThirdViewModel by viewModels()

    @SuppressLint("ResourceType")
    override fun initView() = with(binding){
        btnGoNext.click {
            navigateTo(resId = R.id.firstFragment)
        }
    }

    override fun initObservers() {
    }
}