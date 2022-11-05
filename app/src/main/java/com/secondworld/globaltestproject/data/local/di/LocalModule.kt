package com.secondworld.globaltestproject.data.local.di

import android.content.Context
import androidx.room.Room
import com.secondworld.globaltestproject.data.local.room.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, "app_database").build()

    @Provides
    fun provideDao(database : AppDataBase) = database.userDao()
}