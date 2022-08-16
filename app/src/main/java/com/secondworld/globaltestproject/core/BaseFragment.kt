package com.secondworld.globaltestproject.core

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.CustomLayoutBinding
import com.secondworld.globaltestproject.ui.MainActivity

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) :
    Fragment(), Navigator {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        saveLastFragment()
    }

    fun getLastFragment() = (activity as MainActivity).getLastFragment()

    abstract fun initView()
    abstract fun saveLastFragment()

    override fun navigateTo(resId: Int) =
        findNavController().navigate(resId)

    override fun navigateTo(resId: Int, args: Bundle?, navOptions: NavOptions?) =
        findNavController().navigate(resId, args, navOptions)

    /**
     * Очищаем биндинг во всех фрагментах
     */
    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }

    fun showDialog(
        titleText: String?,
        bodyText: String?,
        callYes: (() -> Unit)?,
        callNo: (() -> Unit)?
    ) {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        val binding = CustomLayoutBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        binding.tvBody.text = bodyText
        binding.tvTitle.text = titleText
        binding.btnYes.setOnClickListener {
            callYes?.invoke()
            dialog.dismiss()
        }
        binding.btnNo.setOnClickListener {
            callNo?.invoke()
            dialog.dismiss()
        }
        dialog.show()
    }
}