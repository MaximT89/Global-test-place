package com.secondworld.globaltestproject.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.ui.MainActivity

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) :
    Fragment(), Navigator{

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

    /**
     * Очищаем биндинг во всех фрагментах
     */
    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}