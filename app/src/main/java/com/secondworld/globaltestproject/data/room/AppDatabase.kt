package com.secondworld.globaltestproject.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityTag::class, EntityWord::class],  version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): AppDao
}