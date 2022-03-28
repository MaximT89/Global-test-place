package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.storage.Storage
import javax.inject.Inject

class Repository @Inject constructor(private val storage: Storage) {

    fun fetchPersons() = storage.fetchPersons()
}