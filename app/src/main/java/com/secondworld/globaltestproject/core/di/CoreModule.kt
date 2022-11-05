package com.secondworld.globaltestproject.core.di

import com.secondworld.globaltestproject.core.bases.BaseSharedPreferences
import com.secondworld.globaltestproject.core.bases.Dispatchers
import com.secondworld.globaltestproject.core.common.ResourceProvider
import com.secondworld.globaltestproject.core.remote.NetworkInterceptor
import com.secondworld.globaltestproject.core.remote.ResponseWrapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {

    @Binds
    abstract fun bindResponseWrapper(responseWrapper: ResponseWrapper.Impl) : ResponseWrapper

    @Binds
    abstract fun bindDispatchers(dispatchers : Dispatchers.Impl) : Dispatchers

    @Binds
    abstract fun bindResourceProvider(provider : ResourceProvider.Impl) : ResourceProvider

    @Binds
    abstract fun bindNetworkInterceptor(interceptor: NetworkInterceptor.Impl) : NetworkInterceptor

    @Binds
    abstract fun bindSharedPreferences(prefs : BaseSharedPreferences.Impl) : BaseSharedPreferences
}