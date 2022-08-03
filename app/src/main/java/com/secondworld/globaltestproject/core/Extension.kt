package com.secondworld.globaltestproject.core
import android.content.SharedPreferences
import android.util.Log

fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) =
    edit().also(operation).apply()

fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
    val key = pair.first
    when (val value = pair.second) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        else -> error("Only primitive types can be stored in SharedPreferences")
    }
}

fun log(message: String) {
    Log.d("TAG", "log: $message")
}

