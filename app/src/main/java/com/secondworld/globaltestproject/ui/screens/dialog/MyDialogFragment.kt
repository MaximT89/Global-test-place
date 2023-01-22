package com.secondworld.globaltestproject.ui.screens.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.DialogFragmentMyBinding

class MyDialogFragment : DialogFragment() {

    private var _binding: DialogFragmentMyBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogFragmentMyBinding.inflate(LayoutInflater.from(context))

        val textFromFirst = arguments?.get("key")

        binding.textFromFirstFragment.text = textFromFirst.toString()

        binding.btnGoSecond.click {
            findNavController().navigate(
                R.id.action_myDialogFragment_to_secondFragment,
                bundleOf("key1" to binding.editTextDialog.text.toString())
            )
        }

        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .setPositiveButton("ok") { _, _ ->
                findNavController().navigate(
                    R.id.action_myDialogFragment_to_secondFragment,
                    bundleOf("key1" to binding.editTextDialog.text.toString())
                )
            }
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}