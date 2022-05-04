package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.BuildConfig
import com.secondworld.globaltestproject.data.animals.remote.api.ApiServiceAnimal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient() : Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiServiceAnimal = retrofit.create(ApiServiceAnimal::class.java)
}