package com.secondworld.globaltestproject.data.user.cache.room

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : UserEntity)

    @Delete
    suspend fun deleteUser(user : UserEntity)

    @Query("SELECT * FROM user_table WHERE name = :name ;")
    suspend fun getUsers(name : String) : List<UserEntity>

    @Query("SELECT * FROM user_table ;")
    suspend fun getUsers() : List<UserEntity>

    @Query("DELETE FROM user_table;")
    suspend fun dropTable()
}