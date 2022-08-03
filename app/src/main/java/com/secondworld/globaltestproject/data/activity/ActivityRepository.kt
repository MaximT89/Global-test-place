package com.secondworld.globaltestproject.data.activity

import androidx.annotation.IdRes
import com.secondworld.globaltestproject.core.FragmentLabelAdapter
import javax.inject.Inject

class ActivityRepository @Inject constructor(
    private val preferences: ActivityPrefs,
    private val fragmentLabelAdapter: FragmentLabelAdapter
) {

    fun loadLastFragment() : Int {
        return fragmentLabelAdapter.getFragmentByLabel(preferences.loadLastFragment()!!)
    }

    fun saveLastFragment(value: String) {
        preferences.saveLastFragment(value)
    }
}