package com.secondworld.globaltestproject.ui.screens.first

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.BuildConfig
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    // test
    override fun initView() {

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("key")
            ?.observe(viewLifecycleOwner) {
                binding.testText.text = it
            }

        binding.btnGoDialog.click {
            navigateTo(
                R.id.action_firstFragment_to_myDialogFragment,
                bundleOf("key" to "Hello my dialog")
            )
        }
    }

    override fun initObservers() = Unit

}