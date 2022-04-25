package com.secondworld.globaltestproject.domain.interactor

import com.secondworld.globaltestproject.data.repository.Repository
import javax.inject.Inject

class UserInteractor @Inject constructor(private val repository: Repository) {

    fun get() = repository.fetchUsers()
}