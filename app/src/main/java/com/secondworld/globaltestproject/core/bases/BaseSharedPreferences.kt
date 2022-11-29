package com.secondworld.globaltestproject.core.bases

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface BaseSharedPreferences {

    fun defaultPref(): SharedPreferences

    class Impl @Inject constructor(@ApplicationContext private val context: Context) :
        BaseSharedPreferences {

        companion object {
            private const val APP_PREF = "app_prefs"
        }

        override fun defaultPref(): SharedPreferences =
            context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
    }
}