package com.secondworld.globaltestproject.data.room

import androidx.room.*


@Dao
interface AppDao {

    @Transaction
    @Query("SELECT * FROM EntityWord")
    suspend fun getWordsWithTags(): List<WordsWithTags>?

    @Transaction
    @Query("SELECT * FROM EntityWord WHERE enWord = :word")
    suspend fun getWordsWithTagsByEnWorld(word: String): List<WordsWithTags>?

    @Transaction
    suspend fun insert(wordsWithTags: WordsWithTags) {
        insert(wordsWithTags.word)
        wordsWithTags.tags?.let { tag ->
            tag.forEach {
                insert(it)
            }
        }
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dialog: EntityWord)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tag: EntityTag)

    @Query("DELETE FROM EntityWord WHERE enWord = :enWord")
    suspend fun deleteWord(enWord: String)

    @Query("DELETE FROM EntityTag WHERE tag = :tag")
    suspend fun deleteTag(tag: String)

    @Query("SELECT * FROM EntityWord")
    suspend fun getAllWords(): List<EntityWord>?

    @Query("SELECT * FROM EntityTag")
    suspend fun getAllTags(): List<EntityTag>?
}