package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val storageName: StorageName) : Repository {

    override fun getRandomName() = storageName.listNames().random()

    override fun getRandomAge() = (1..70).random()
    override fun getRandomId() = (1..999999999).random()

    override fun getListPersons() = mutableListOf<Person>().apply {
        repeat(10) {
            add(Person(getRandomId(), getRandomName(), getRandomAge(), false))
        }
    }
}