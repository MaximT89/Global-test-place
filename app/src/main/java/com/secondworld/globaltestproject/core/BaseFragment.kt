package com.secondworld.globaltestproject.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.notification.NotificationAdapter

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

open class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) : Fragment(){

    private var _viewBinding : B? = null
    protected val binding get() = checkNotNull(_viewBinding)

    private var _notificationAdapter : NotificationAdapter? = null
    protected val notificationAdapter get() = checkNotNull(_notificationAdapter)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        _notificationAdapter = NotificationAdapter.Base(requireActivity())
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}