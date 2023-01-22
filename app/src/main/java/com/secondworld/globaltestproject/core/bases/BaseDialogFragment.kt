package com.secondworld.globaltestproject.core.bases

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

typealias InflateDialog<T> = (LayoutInflater) -> T

abstract class BaseDialogFragment<B : ViewBinding>(
    private val inflate: InflateDialog<B>,
) : DialogFragment() {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)

    abstract fun initView()
    open fun positiveBtnClick() = Unit

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _viewBinding = inflate.invoke(LayoutInflater.from(context))

        initView()

        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .setPositiveButton("ok") { _, _ ->
                positiveBtnClick()
            }
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}