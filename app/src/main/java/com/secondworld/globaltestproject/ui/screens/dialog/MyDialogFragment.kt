package com.secondworld.globaltestproject.ui.screens.dialog

import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.core.bases.BaseDialogFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.DialogFragmentMyBinding

class MyDialogFragment :
    BaseDialogFragment<DialogFragmentMyBinding>(DialogFragmentMyBinding::inflate) {

    override fun initView() = with(binding) {

        val textFromFirst = arguments?.get("key")

        textFromFirstFragment.text = textFromFirst.toString()

        btnGoBack.click {
            findNavController().apply {
                previousBackStackEntry?.savedStateHandle?.set(
                    "key",
                    editTextDialog.text.toString()
                )
                popBackStack()
            }
        }
    }
}