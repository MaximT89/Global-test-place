package com.secondworld.globaltestproject.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "age") val age : Int
)