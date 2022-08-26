package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.domain.repository.Repository

class RepositoryImpl() : Repository {

    override fun getRandomId() = (1..999999).random()


    override fun getListPersons() = mutableListOf<Person>().apply {
        add(Person(getRandomId(), R.drawable.banner_1))
        add(Person(getRandomId(), R.drawable.banner_2))
        add(Person(getRandomId(), R.drawable.banner_3))
        add(Person(getRandomId(), R.drawable.banner_4))
        add(Person(getRandomId(), R.drawable.banner_5))
    }
}