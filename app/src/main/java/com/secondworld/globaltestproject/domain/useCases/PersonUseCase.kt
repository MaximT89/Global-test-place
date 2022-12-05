package com.secondworld.globaltestproject.domain.useCases

import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class PersonUseCase @Inject constructor(private val repository: Repository) {

    fun getListPerson() = repository.getListPersons()
}