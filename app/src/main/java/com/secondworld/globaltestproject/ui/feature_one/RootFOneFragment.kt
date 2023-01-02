package com.secondworld.globaltestproject.ui.feature_one

import androidx.navigation.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentRootFOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFOneFragment : BaseFragment<FragmentRootFOneBinding, RootFOneViewModel>(
    FragmentRootFOneBinding::inflate,
    RootFOneViewModel::class.java) {

    override fun initView() {
//        view?.findNavController()?.navigate(R.id.action_rootFOneFragment_to_featureOneNavigation2)
    }

    override fun initObservers() = Unit

}