package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SecondViewModel @Inject constructor() : ViewModel() {

    private val _testString = MutableLiveData(0)
    val testString: LiveData<Int> = _testString



    private var myJob : Job? = null

    private fun startRepeatingJob(timeInterval: Long): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            while (isActive) {
                _testString.postValue(_testString.value?.plus(1))
                delay(timeInterval)
            }
        }
    }

    fun startTimer() {
        if(myJob?.isActive != true) {
            myJob = startRepeatingJob(1000)
        }
    }

    fun stopTimer() {
        myJob?.cancel()
    }


}