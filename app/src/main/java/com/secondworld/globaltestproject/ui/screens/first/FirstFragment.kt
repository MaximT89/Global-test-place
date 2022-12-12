package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.adapters.MainScreenAdapter

class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    private var delegateAdapter: MainScreenAdapter? = null

    override fun initView() = with(binding) {

        btnGoNext.click {
            navigateTo(R.id.secondFragment)
        }

        delegateAdapter = MainScreenAdapter(viewModel::updateFavourite)

        filterName.click {
            viewModel.filterData()
        }

        recyclerView.adapter = delegateAdapter
    }

    override fun initObservers() {

        viewModel.dataAnimals.observe { listAnimal ->
            delegateAdapter?.items = listAnimal
        }
    }
}