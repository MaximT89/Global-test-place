package com.secondworld.globaltestproject.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideService(retrofit: Retrofit) : Service = retrofit.create(Service::class.java)
}