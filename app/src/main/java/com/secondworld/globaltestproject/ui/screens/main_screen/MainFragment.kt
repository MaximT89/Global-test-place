package com.secondworld.globaltestproject.ui.screens.main_screen

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {
    override val viewModel: MainViewModel by viewModels()

    private val mainAdapter = MainAdapter()

    override fun initView() = with(binding) {
        recyclerView.adapter = mainAdapter

        btnCreateNewItems.click {
            viewModel.getNewTenItems()
        }

        clearTable.click {
            viewModel.clearTable()
        }
    }

    override fun initCallbacks() {
        mainAdapter.callDeleteItem = {
            id -> viewModel.deleteItem(id)
        }
    }

    override fun initObservers() {

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.users.collect { newItems ->
                mainAdapter.items = newItems
            }
        }
    }
}