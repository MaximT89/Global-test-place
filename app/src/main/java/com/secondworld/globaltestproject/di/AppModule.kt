package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindRepo(repositoryImpl: RepositoryImpl) : Repository
}