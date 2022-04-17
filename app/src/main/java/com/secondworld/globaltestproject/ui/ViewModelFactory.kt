package com.secondworld.globaltestproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.secondworld.globaltestproject.core.ResourceProvider
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val personUseCase: PersonUseCase, private val resourceProvider: ResourceProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return if(modelClass.isAssignableFrom(MainViewModel::class.java)){
           MainViewModel(this.personUseCase, this.resourceProvider) as T
       } else {
           throw IllegalArgumentException("ViewModel not found")
       }
    }
}