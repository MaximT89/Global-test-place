package com.secondworld.globaltestproject.ui.feature_third

import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentRootFThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFThirdFragment : BaseFragment<FragmentRootFThirdBinding, RootFThirdViewModel>(
    FragmentRootFThirdBinding::inflate,
    RootFThirdViewModel::class.java) {
    override fun initView() {
        findNavController().navigate(R.id.action_rootFThirdFragment_to_featureThreeNavigation)

    }

    override fun initObservers() {
    }
}