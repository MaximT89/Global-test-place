package com.secondworld.globaltestproject.core.bases

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.secondworld.globaltestproject.core.navigation.Navigator
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.common.NetworkStateManager

abstract class BaseActivity : AppCompatActivity(), Navigator, ContextScope {

    override fun navigateTo(resId: Int, args: Bundle?, navOptions: NavOptions?) =
        findNavController(R.id.nav_host_fragment).navigate(resId, args, navOptions)

    override fun navigateTo(resId: Int, args: Bundle?) = findNavController(R.id.nav_host_fragment).navigate(resId, args)

    override fun navigateTo(resId: Int) = findNavController(R.id.nav_host_fragment).navigate(resId)

    override fun navigateUp() { findNavController(R.id.nav_host_fragment).navigateUp() }

    override fun getContext() : Context {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NetworkStateManager.getNetworkConnectivityStatus()?.observe(this, activeNetworkStateObserver)
    }

    private val activeNetworkStateObserver: Observer<Boolean?> =
        Observer<Boolean?> { isConnected -> resultLogic(isConnected) }

    private fun resultLogic(connected: Boolean?) : Unit?{

        return internetCallback?.invoke(connected)
    }

    open var internetCallback : ((data : Boolean?) -> Unit)? = null

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
    }
}