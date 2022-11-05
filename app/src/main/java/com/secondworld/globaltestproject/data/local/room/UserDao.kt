package com.secondworld.globaltestproject.data.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : UserEntity)

    @Query("DELETE FROM user_table WHERE id = :id")
    suspend fun deleteUser(id : Int)

    @Query("SELECT * FROM user_table WHERE name = :name")
    fun getUsersByName(name : String) : Flow<List<UserEntity>>

    @Query("SELECT * FROM user_table")
    fun getUsers() : Flow<List<UserEntity>>

    @Query("DELETE FROM user_table")
    suspend fun dropTable()
}