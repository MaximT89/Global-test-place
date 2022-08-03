package com.secondworld.globaltestproject.data.activity

import com.secondworld.globaltestproject.core.BaseSharedPreferences
import com.secondworld.globaltestproject.core.editMe
import com.secondworld.globaltestproject.core.put
import javax.inject.Inject

class ActivityPrefs @Inject constructor(private val basePrefs : BaseSharedPreferences) {

    companion object {
        const val LAST_FRAGMENT = "last_fragment"
    }

    fun loadLastFragment() = basePrefs.defaultPref().getString(LAST_FRAGMENT, "")

    fun saveLastFragment(value : String) {
        basePrefs.defaultPref().editMe { it.put(LAST_FRAGMENT to value) }
    }
}