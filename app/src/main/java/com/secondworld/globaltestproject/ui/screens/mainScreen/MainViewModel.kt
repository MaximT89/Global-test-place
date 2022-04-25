package com.secondworld.globaltestproject.ui.screens.mainScreen

import androidx.lifecycle.*
import com.secondworld.globaltestproject.core.Observe
import com.secondworld.globaltestproject.data.model.User
import com.secondworld.globaltestproject.domain.interactor.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: UserInteractor,
    private val communicationUsers: CommunicationUsers
) : ViewModel(), Observe<List<User>> {

    override fun observe(owner: LifecycleOwner, observer: Observer<List<User>>) {
        communicationUsers.observe(owner, observer)
    }

    init {
        getUsers()
    }

    private fun getUsers() {
        communicationUsers.map(interactor.get())
    }
}