package com.secondworld.globaltestproject.core

import android.content.Context
import androidx.annotation.StringRes
import com.secondworld.globaltestproject.R

interface ResourceProvider{

    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: Any): String

    class Base(private val context: Context) : ResourceProvider{
        override fun string(id: Int) = context.getString(id)
        override fun string(id: Int, vararg args: Any) = context.getString(id, *args)
    }
}