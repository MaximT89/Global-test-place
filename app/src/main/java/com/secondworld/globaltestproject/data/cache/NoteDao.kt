package com.secondworld.globaltestproject.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(noteEntity: NoteEntity)

    @Query("SELECT * FROM note_table WHERE id = :id ")
    suspend fun getNote(id : Int) : NoteEntity?

    @Query("SELECT * FROM note_table")
    suspend fun getNotes() : List<NoteEntity>?
}