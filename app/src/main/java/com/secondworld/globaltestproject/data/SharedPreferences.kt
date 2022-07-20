package com.secondworld.globaltestproject.data

import android.content.Context
import android.content.SharedPreferences
import com.secondworld.globaltestproject.core.editMe
import com.secondworld.globaltestproject.core.put
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private const val APP_PREF = "app_prefs"
        private const val PROFILE_SCORE = "profile_score"
    }

    private fun defaultPref(): SharedPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

    fun getScore() = defaultPref().getInt(PROFILE_SCORE, 0)
    fun saveScore(value: Int) {
        defaultPref().editMe { it.put(PROFILE_SCORE to value) } }
}




