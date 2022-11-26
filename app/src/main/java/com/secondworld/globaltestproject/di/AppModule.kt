package com.secondworld.globaltestproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindCommunicationFoo(communication: CommunicationFoo.UpdateUi) : CommunicationFoo
}