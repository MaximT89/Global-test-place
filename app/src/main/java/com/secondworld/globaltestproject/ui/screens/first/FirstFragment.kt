package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.adapters.MainScreenAdapter
import com.secondworld.globaltestproject.ui.adapters.catAdapterDelegate
import com.secondworld.globaltestproject.ui.adapters.dogAdapterDelegate

class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    private var delegateAdapter: MainScreenAdapter? = null

    override fun initView() = with(binding) {

        btnGoNext.click {
            navigateTo(R.id.secondFragment)
        }

        delegateAdapter = MainScreenAdapter()


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