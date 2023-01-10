package com.secondworld.globaltestproject.ui.feature_one.screen_one

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFOneScreenOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FOneScreenOneFragment : BaseFragment<FragmentFOneScreenOneBinding, FOneScreenOneViewModel>(
    FragmentFOneScreenOneBinding::inflate,
    FOneScreenOneViewModel::class.java) {

    private val testAdapter = TestAdapter()

    override fun initView() = with(binding) {

        rv.adapter = testAdapter

        testAdapter.submitList(createSomeModels())

        btnGoNext.click {
            navigateTo(R.id.action_FOneScreenOneFragment2_to_FOneScreenTwoFragment2)
        }
    }

    private fun createSomeModels(): List<AdapterModel> {
        val list = mutableListOf<AdapterModel>()
        for (i in 0..100){
            list.add(AdapterModel(i, i.toString()))
        }
        return list
    }

    override fun initObservers() = Unit
}