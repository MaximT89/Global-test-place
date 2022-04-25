package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.ui.screens.mainScreen.CommunicationUsers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindCommunicationUsers(communication: CommunicationUsers.UiUpdate) : CommunicationUsers
}