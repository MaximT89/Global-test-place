package com.secondworld.globaltestproject.core

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BaseSharedPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private const val APP_PREF = "app_prefs"
    }

    fun defaultPref(): SharedPreferences =
        context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
}