package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.cache.CacheDataSource
import com.secondworld.globaltestproject.data.storage.NoteStorage
import com.secondworld.globaltestproject.domain.models.NoteDomain
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val cacheDataSource: CacheDataSource
) :
    Repository {

    override suspend fun createNote() {
        cacheDataSource.createNote()
    }

    override suspend fun getNotes(): List<NoteDomain>? {
        return cacheDataSource.getNotes()
    }

    override suspend fun getNoteById(id: Int): NoteDomain? {
        return cacheDataSource.getNote(id)
    }
}