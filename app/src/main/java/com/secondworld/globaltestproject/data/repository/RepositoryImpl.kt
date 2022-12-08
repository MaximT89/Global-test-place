package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.storages.UserStorage
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val storageName: UserStorage) : Repository {

    override fun getRandomName() = storageName.listNames().random()

    override fun getRandomProfession() = storageName.listProfessions().random()

    override fun getRandomAge() = (1..70).random()

    override fun getRandomActive() = listOf(
        true,
        false
    ).random()

    override fun getListPersons() = mutableListOf<Person>().apply {
        repeat(300) {
            add(
                Person(
                    getRandomName(),
                    getRandomAge(),
                    getRandomActive(),
                    getRandomProfession()
                )
            )
        }
    }
}