package com.secondworld.globaltestproject.data.remote.di

import com.secondworld.globaltestproject.data.remote.api.PostApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    fun providePostApi(retrofit: Retrofit) : PostApi = retrofit.create(PostApi::class.java)
}