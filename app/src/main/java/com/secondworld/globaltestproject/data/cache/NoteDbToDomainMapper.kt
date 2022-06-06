package com.secondworld.globaltestproject.data.cache

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.domain.models.NoteDomain
import javax.inject.Inject

class NoteDbToDomainMapper @Inject constructor() : Mapper<NoteEntity,NoteDomain> {
    override fun map(data: NoteEntity): NoteDomain {
        return NoteDomain(data.id, data.note)
    }
}