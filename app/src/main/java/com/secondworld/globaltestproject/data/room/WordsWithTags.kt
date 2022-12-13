package com.secondworld.globaltestproject.data.room

import androidx.room.Embedded
import androidx.room.Relation

data class WordsWithTags(
    @Embedded
    val word : EntityWord,

    @Relation(
        parentColumn = "wordId",
        entityColumn = "tagId"
    )
    val tags: List<EntityTag>?
)