package com.secondworld.globaltestproject.domain.user

import com.secondworld.globaltestproject.data.user.cache.room.UserEntity
import com.secondworld.globaltestproject.ui.App

class UserInteractor {

    private val dao = App.INSTANCE?.userDao()

    suspend fun insertUser(user : UserEntity) {
        dao?.insertUser(user)
    }

    suspend fun getUsers(name :String) = dao?.getUsers(name)

    suspend fun getUsers() = dao?.getUsers()

    suspend fun dropTable() = dao?.dropTable()

}