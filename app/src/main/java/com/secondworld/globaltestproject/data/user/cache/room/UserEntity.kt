package com.secondworld.globaltestproject.data.user.cache.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val age : Int
)