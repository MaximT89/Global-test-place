package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {

    @Binds
    abstract fun bindRepository(repository: RepositoryImpl) : Repository
}