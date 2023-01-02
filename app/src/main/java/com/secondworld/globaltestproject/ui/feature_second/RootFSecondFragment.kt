package com.secondworld.globaltestproject.ui.feature_second

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentRootFSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFSecondFragment : BaseFragment<FragmentRootFSecondBinding, RootFSecondViewModel>(
    FragmentRootFSecondBinding::inflate,
    RootFSecondViewModel::class.java) {
    override fun initView() {
//        findNavController().navigate(R.id.action_rootFSecondFragment_to_featureTwoNavigation)

    }

    override fun initObservers() = Unit

}