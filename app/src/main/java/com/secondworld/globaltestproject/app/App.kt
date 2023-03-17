package com.secondworld.globaltestproject.app

import android.app.Application
import com.secondworld.globaltestproject.core.common.NetworkMonitoringUtil
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {

    var mNetworkMonitoringUtil: NetworkMonitoringUtil? = null
    override fun onCreate() {
        super.onCreate()
        mNetworkMonitoringUtil = NetworkMonitoringUtil(applicationContext)
        mNetworkMonitoringUtil!!.checkNetworkState()
        mNetworkMonitoringUtil!!.registerNetworkCallbackEvents()
    }
}