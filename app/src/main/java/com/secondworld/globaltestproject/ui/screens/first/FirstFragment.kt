package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.ui.adapters.catAdapterDelegate
import com.secondworld.globaltestproject.ui.adapters.dogAdapterDelegate

class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    private var delegateAdapter : ListDelegationAdapter<List<Animal>>? = null

    override fun initView() = with(binding) {

        btnGoNext.click {
            navigateTo(R.id.secondFragment)
        }

        delegateAdapter = ListDelegationAdapter(
            catAdapterDelegate(),
            dogAdapterDelegate()
        )

        recyclerView.adapter = delegateAdapter
    }

    override fun initObservers() {

        viewModel.dataAnimals.observe { listAnimal ->
            delegateAdapter?.items = listAnimal
        }
    }
}