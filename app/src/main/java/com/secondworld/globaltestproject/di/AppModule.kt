package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.data.userBonuses.RepositoryUserBonusesImpl
import com.secondworld.globaltestproject.data.userInfo.RepositoryUserInfoImpl
import com.secondworld.globaltestproject.domain.userBonuses.RepositoryUserBonuses
import com.secondworld.globaltestproject.domain.userInfo.RepositoryUserInfo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindRepositoryUserInfo(repository: RepositoryUserInfoImpl) : RepositoryUserInfo

    @Binds
    abstract fun bindRepositoryUserBonuses(repository: RepositoryUserBonusesImpl) : RepositoryUserBonuses
}