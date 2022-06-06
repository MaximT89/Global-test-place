package com.secondworld.globaltestproject.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [NoteEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun noteDao() : NoteDao
}

val MIGRATION_1_2  = object : Migration(1, 2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("DROP TABLE IF EXISTS `note_table`")
        database.execSQL("CREATE TABLE `note_table_new` (" +
                "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "`note` TEXT NOT NULL)")
        database.execSQL("ALTER TABLE `note_table_new` RENAME TO `note_table`")
    }
}