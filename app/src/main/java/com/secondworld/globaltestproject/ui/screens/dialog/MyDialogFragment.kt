package com.secondworld.globaltestproject.ui.screens.dialog

import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseDialogFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.DialogFragmentMyBinding

class MyDialogFragment :
    BaseDialogFragment<DialogFragmentMyBinding>(DialogFragmentMyBinding::inflate) {

    override fun initView() {
        val textFromFirst = arguments?.get("key")

        binding.textFromFirstFragment.text = textFromFirst.toString()

        binding.btnGoSecond.click {

            val navController = findNavController()
            navController.previousBackStackEntry?.savedStateHandle?.set("key", binding.editTextDialog.text.toString())
            navController.popBackStack()
        }
    }
}