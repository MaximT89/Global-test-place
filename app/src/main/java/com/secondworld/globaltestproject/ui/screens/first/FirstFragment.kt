package com.secondworld.globaltestproject.ui.screens.first

import com.bumptech.glide.Glide
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.data.model.ResponseDogImage
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    override fun initView() = with(binding) {
        btnRefresh.click(viewModel::getServerData)
    }

    override fun initObservers() = with(viewModel){
        mainUiState.observe { state ->
            when(state) {
                is MainUiState.Error -> showSnackbar(state.errorMessage)
                is MainUiState.Success -> updateUi(state.data)
            }
        }
    }

    private fun updateUi(data: ResponseDogImage) {

        Glide.with(requireActivity())
            .load(data.message)
            .into(binding.dogImage)

    }

}