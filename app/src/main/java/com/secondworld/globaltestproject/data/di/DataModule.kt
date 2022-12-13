package com.secondworld.globaltestproject.data.di

import android.content.Context
import androidx.room.Room
import com.secondworld.globaltestproject.data.room.AppDao
import com.secondworld.globaltestproject.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideDao(appDatabase: AppDatabase) : AppDao = appDatabase.userDao()
}