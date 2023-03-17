package com.secondworld.globaltestproject.core.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

class NetworkMonitoringUtil(applicationContext: Context) : ConnectivityManager.NetworkCallback() {
    private var mNetworkRequest: NetworkRequest? = null
    private var mConnectivityManager: ConnectivityManager? = null

    init {
        mNetworkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build();

        mConnectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        NetworkStateManager.setNetworkConnectivityStatus(true)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        NetworkStateManager.setNetworkConnectivityStatus(false)
    }

    fun registerNetworkCallbackEvents() {
        mConnectivityManager!!.registerNetworkCallback(mNetworkRequest!!, this)
    }

    fun checkNetworkState() {
        try {
            val networkInfo = mConnectivityManager!!.activeNetworkInfo
            NetworkStateManager.setNetworkConnectivityStatus(
                networkInfo != null
                        && networkInfo.isConnected
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}