package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class MainViewModel : ViewModel() {

    val result: LiveData<Result> = liveData {
        val data = someSuspendingFunction()
        emit(data)
    }

    private fun someSuspendingFunction(): Result {
        return Result(15)
    }

}