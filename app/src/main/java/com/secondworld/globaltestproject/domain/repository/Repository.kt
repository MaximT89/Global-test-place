package com.secondworld.globaltestproject.domain.repository

import com.secondworld.globaltestproject.data.cache.NoteDao
import com.secondworld.globaltestproject.domain.models.NoteDomain

interface Repository {

    suspend fun createNote()
    suspend fun getNotes() : List<NoteDomain>?
    suspend fun getNoteById(id : Int) : NoteDomain?
}