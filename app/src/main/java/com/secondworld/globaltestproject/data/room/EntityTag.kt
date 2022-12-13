package com.secondworld.globaltestproject.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = EntityWord::class,
    parentColumns = arrayOf("wordId"),
    childColumns = arrayOf("tagId"),
    onDelete = ForeignKey.CASCADE)])
data class EntityTag(
    @ColumnInfo(name = "tagId") @PrimaryKey(autoGenerate = true) val tagId: Int,
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "wordOwnerId") val wordOwnerId: Int?
)