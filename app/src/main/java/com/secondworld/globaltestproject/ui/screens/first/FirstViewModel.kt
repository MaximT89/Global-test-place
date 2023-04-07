package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.common.ResourceProvider
import com.secondworld.globaltestproject.core.extension.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val provider: ResourceProvider) : BaseViewModel() {

    init {
        foo()
    }

    fun foo() {
        viewModelScope.launch(Dispatchers.IO) {
            test1()
            test2()
        }
    }

    private suspend fun test1() {
        delay(2000)
        log("first")
    }

    private suspend fun test2() {
        log("second")
    }
}





