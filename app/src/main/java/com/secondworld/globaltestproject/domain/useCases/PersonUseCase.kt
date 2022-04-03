package com.secondworld.globaltestproject.domain.useCases

import com.secondworld.globaltestproject.domain.repository.Repository

class PersonUseCase(private val repository: Repository) {

    fun getListPerson() = repository.getListPersons()
}