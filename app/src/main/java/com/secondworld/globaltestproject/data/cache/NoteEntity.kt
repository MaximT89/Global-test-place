package com.secondworld.globaltestproject.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val note : String
)