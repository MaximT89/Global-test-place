package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()
    private val mainAdapter = MainAdapter()

    override fun initView() = with(binding){
        rv.adapter = mainAdapter

    }

    override fun initObservers() = with(viewModel) {
        mainData.observe { list ->
            mainAdapter.submitList(list)
        }

    }

    override fun initCallbacks() {

        mainAdapter.callbackDel = {
            viewModel.deleteItem(it)
        }
    }
}