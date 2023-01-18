package com.secondworld.globaltestproject.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val test2 = MutableLiveData<Int>()

    init {
        test1()
    }


    fun test1() {
        viewModelScope.launch(Dispatchers.Default) {
            test2.value = 2
        }

    }
}