package com.secondworld.globaltestproject.data.di

import com.secondworld.globaltestproject.data.remote.DogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideDogApi(retrofit: Retrofit) : DogService = retrofit.create(DogService::class.java)
}