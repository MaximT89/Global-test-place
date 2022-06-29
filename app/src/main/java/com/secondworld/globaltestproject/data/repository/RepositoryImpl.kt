package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.domain.repository.Repository
import com.secondworld.globaltestproject.ui.RecyclerViewItem

class RepositoryImpl(private val storageName : StorageName) : Repository {

    override fun getRandomName() = storageName.listNames().random()

    override fun getRandomAge() = (1..70).random()

    override fun getListPersons() = mutableListOf<RecyclerViewItem>().apply {
        repeat(10) {
            add(Person(getRandomName(), getRandomAge()))
        }
    }


}