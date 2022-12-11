package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.data.remote.model.ResponsePost
import com.secondworld.globaltestproject.data.repository.PostRepository
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding) {}

    override fun initObservers() = with(viewModel) {

        postScreenState.observe { state ->
            when (state) {
                is PostScreenState.Error -> updateUi(error = true)
                PostScreenState.Loading -> updateUi(progress = true)
                is PostScreenState.Success -> updateUi(content = state.data)
            }
        }
    }

    private fun updateUi(
        progress: Boolean = false,
        content: ResponsePost? = null,
        error: Boolean = false,
    ) = with(binding) {

        if (progress) progressBar.show()
        else progressBar.hide()

        if (content != null) {
            contentView.show()
            title.text = content.title
            description.text = content.body
        } else contentView.hide()

        if(error) errorView.show()
        else errorView.hide()

    }


}