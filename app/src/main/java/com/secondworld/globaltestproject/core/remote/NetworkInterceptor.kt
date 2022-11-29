package com.secondworld.globaltestproject.core.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Данный интерсептор проверяет есть ли у пользователя интернет, и метод [intercept] вернет true -
 * в случае если интернет есть, и false - если интернет в данный момент отсутствует
 */
interface NetworkInterceptor : Interceptor {

    fun isConnected(): Boolean

    class Impl @Inject constructor(@ApplicationContext private val applicationContext: Context) :
        Interceptor, NetworkInterceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            if (!isConnected()) {
                throw NoInternetConnectionException()
            }
            val newRequest = chain
                .request()
                .newBuilder()
                .build()
            return chain.proceed(newRequest)
        }

        override fun isConnected(): Boolean {
            var result = false
            val connectivityManager =
                applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val activeNetwork =
                    connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
                result = when {
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                connectivityManager.run {
                    connectivityManager.activeNetworkInfo?.run {
                        result = when (type) {
                            ConnectivityManager.TYPE_WIFI -> true
                            ConnectivityManager.TYPE_MOBILE -> true
                            ConnectivityManager.TYPE_ETHERNET -> true
                            else -> false
                        }
                    }
                }
            }

            return result
        }
    }
}