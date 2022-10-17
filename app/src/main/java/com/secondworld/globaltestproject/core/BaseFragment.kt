package com.secondworld.globaltestproject.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) :
    Fragment(){

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)
    protected var toolbar: Toolbar? = null

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
        initObservers()
        initCallbacks()
    }

    open fun initCallbacks() = Unit

    abstract fun initView(): Unit?
    abstract fun initObservers()

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}