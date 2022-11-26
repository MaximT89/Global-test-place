package com.secondworld.globaltestproject.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavOptions

interface Navigator {

    fun navigateTo(
        @IdRes resId: Int,
        args: Bundle?,
        navOptions: NavOptions?
    )

    fun navigateTo(
        @IdRes resId: Int
    )

    fun navigateTo(
        @IdRes resId: Int,
        args: Bundle?,
    )

    fun navigateUp()
}