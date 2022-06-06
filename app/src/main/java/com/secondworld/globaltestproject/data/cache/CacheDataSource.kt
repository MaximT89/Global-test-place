package com.secondworld.globaltestproject.data.cache

import com.secondworld.globaltestproject.data.storage.NoteStorage
import com.secondworld.globaltestproject.domain.models.NoteDomain
import javax.inject.Inject

class CacheDataSource @Inject constructor(
    private val dao: NoteDao,
    private val mapper: NoteDbToDomainMapper,
    private val noteStorage: NoteStorage
) {

    suspend fun createNote() {
        dao.insert(noteStorage.generateNewNote())
    }

    suspend fun getNote(id: Int): NoteDomain? {
        return dao.getNote(id)?.let { mapper.map(it) }
    }

    suspend fun getNotes() : List<NoteDomain>?{
        val notes = dao.getNotes()
        return notes?.map { note -> mapper.map(note) }
    }
}