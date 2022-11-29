package com.secondworld.globaltestproject.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideApi(retrofit: Retrofit): ImageLoaderApi = retrofit.create(ImageLoaderApi::class.java)
}