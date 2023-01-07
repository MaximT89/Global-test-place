package com.secondworld.globaltestproject.core.common

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

interface ResourceProvider {

    fun string(@StringRes id: Int): String

    fun string(@StringRes id: Int, vararg args: String?): String

    class Impl @Inject constructor(@ApplicationContext private val context: Context) :
        ResourceProvider {

        override fun string(@StringRes id: Int): String = context.getString(id)

        override fun string(@StringRes id: Int, vararg args: String?): String =
            context.getString(id, *args)
    }
}