package com.secondworld.globaltestproject.domain.main_screen

import com.secondworld.globaltestproject.data.local.room.UserEntity
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertUser(user : UserEntity)

    suspend fun deleteUser(id : Int)

    fun getUsersByName(name : String) : Flow<List<UserEntity>>

    fun getUsers() : Flow<List<UserEntity>>

    suspend fun dropTable()
}