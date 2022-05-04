package com.secondworld.globaltestproject.di

import com.secondworld.globaltestproject.data.animals.repository.AnimalRepositoryImpl
import com.secondworld.globaltestproject.data.common.NetworkHelper
import com.secondworld.globaltestproject.data.common.ResponseHandler
import com.secondworld.globaltestproject.domain.animal.AnimalRepository
import com.secondworld.globaltestproject.domain.animal.interactor.AnimalInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {

    @Binds
    abstract fun bindNetworkHelper(networkHelper: NetworkHelper.Base) : NetworkHelper

    @Binds
    abstract fun bindAnimalRepository(animalRepositoryImpl: AnimalRepositoryImpl) : AnimalRepository
}