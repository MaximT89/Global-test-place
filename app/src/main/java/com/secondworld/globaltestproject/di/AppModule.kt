package com.secondworld.globaltestproject.di

import android.content.Context
import androidx.room.Room
import com.secondworld.globaltestproject.data.cache.AppDatabase
import com.secondworld.globaltestproject.data.cache.MIGRATION_1_2
import com.secondworld.globaltestproject.data.cache.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context : Context) : AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").addMigrations(
            MIGRATION_1_2).build()

    @Provides
    @Singleton
    fun provideNoteDao(appDatabase: AppDatabase) : NoteDao = appDatabase.noteDao()
}