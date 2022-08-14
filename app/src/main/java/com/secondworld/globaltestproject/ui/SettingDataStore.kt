package com.secondworld.globaltestproject.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "setting")

class UserManager(private val dataStore: DataStore<Preferences>) {

    companion object { val USER_AGE_KEY = intPreferencesKey("USER_AGE") }

    suspend fun storeUser(age: Int) { dataStore.edit { it[USER_AGE_KEY] = age } }

    val userAgeFlow: Flow<Int?> = dataStore.data.map { it[USER_AGE_KEY] }
}