package com.secondworld.globaltestproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.secondworld.globaltestproject.domain.user.UserInteractor

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val userInteractor: UserInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(userInteractor) as T
        } else throw Exception("unchecked class")
    }
}