package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val communicationFoo: CommunicationFoo
) : ViewModel(), Observe<Foo> {

    override fun observe(owner: LifecycleOwner, observer: Observer<Foo>) {
        communicationFoo.observe(owner, observer)
    }

    init {
        fetchDataFromInteractor()
    }

    private fun fetchDataFromInteractor(){
        communicationFoo.map(Foo("Foo"))
    }
}