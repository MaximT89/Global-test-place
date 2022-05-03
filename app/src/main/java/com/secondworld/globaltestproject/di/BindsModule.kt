package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.data.ApiResult
import com.secondworld.globaltestproject.data.RepositoryImpl
import com.secondworld.globaltestproject.domain.BaseInteractor
import com.secondworld.globaltestproject.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {

    @Binds
    abstract fun bindInteractor(interactor: BaseInteractor.Base) : BaseInteractor<ApiResult>

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository
}