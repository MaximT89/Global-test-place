package com.secondworld.globaltestproject.data.di

import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.domain.main_screen.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule  {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository
}