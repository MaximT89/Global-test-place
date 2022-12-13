package com.secondworld.globaltestproject.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EntityWord(
    @ColumnInfo(name = "wordId") @PrimaryKey(autoGenerate = true) val wordId: Int,
    @ColumnInfo(name = "enWord") val enWord: String?,
    @ColumnInfo(name = "ruWord") val ruWord: String?,
    @ColumnInfo(name = "successAnswer") val successAnswer: Int = 0,
    @ColumnInfo(name = "failAnswer") val failAnswer: Int = 0,
)

