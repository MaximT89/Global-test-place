package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.local.room.UserDao
import com.secondworld.globaltestproject.data.local.room.UserEntity
import com.secondworld.globaltestproject.domain.main_screen.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val userDao : UserDao) : Repository {

    override suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    override suspend fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }

    override fun getUsersByName(name: String): Flow<List<UserEntity>> = userDao.getUsersByName(name)


    override fun getUsers(): Flow<List<UserEntity>> = userDao.getUsers()

    override suspend fun dropTable() {
        userDao.dropTable()
    }

}