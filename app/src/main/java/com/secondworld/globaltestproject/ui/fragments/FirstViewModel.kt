package com.secondworld.globaltestproject.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private var _score = MutableLiveData(0)
    val score : LiveData<Int> = _score

    fun saveScore(value : Int) {
        _score.value = value
    }
}