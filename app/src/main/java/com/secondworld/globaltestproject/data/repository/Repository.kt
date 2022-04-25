package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.storage.UserStorage
import javax.inject.Inject

class Repository @Inject constructor(private val storage : UserStorage) {

    fun fetchUsers() = storage.getUsers()
}