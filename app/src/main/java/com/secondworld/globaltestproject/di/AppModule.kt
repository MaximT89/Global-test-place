package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.domain.repository.Repository
import com.secondworld.globaltestproject.ui.CommunicationFoo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.net.ResponseCache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindCommunicationFoo(communication: CommunicationFoo.UpdateUi) : CommunicationFoo
}