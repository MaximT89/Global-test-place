package com.secondworld.globaltestproject.core.common

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object NetworkStateManager {
    private val activeNetworkStatusMLD = MutableLiveData<Boolean>()

    fun setNetworkConnectivityStatus(connectivityStatus: Boolean) {
        if (Looper.myLooper() == Looper.getMainLooper()) activeNetworkStatusMLD.setValue(connectivityStatus)
        else activeNetworkStatusMLD.postValue(connectivityStatus)
    }

    fun getNetworkConnectivityStatus(): LiveData<Boolean>? {
        return activeNetworkStatusMLD
    }
}