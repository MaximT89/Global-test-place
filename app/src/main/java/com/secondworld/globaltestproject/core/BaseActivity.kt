package com.secondworld.globaltestproject.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<VB : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    protected val binding get() = _binding as VB

    protected abstract fun viewModelClass(): Class<VM>

    protected val viewModel: VM by lazy {
        ViewModelProvider(this)[viewModelClass()]
    }

    protected abstract val bindingInflater : (LayoutInflater) -> VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)

        initViews()
        initObservers()
    }

    abstract fun initObservers()
    abstract fun initViews()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}