package com.secondworld.globaltestproject.data.animals.repository

import com.secondworld.globaltestproject.data.animals.remote.api.ApiServiceAnimal
import com.secondworld.globaltestproject.data.common.NetworkHelper
import com.secondworld.globaltestproject.domain.animal.AnimalRepository
import com.secondworld.globaltestproject.domain.animal.model.AnimalModel
import com.secondworld.globaltestproject.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor(
    private val apiServiceAnimal: ApiServiceAnimal,
    private val networkHelper: NetworkHelper,
    private val animalDataToDomainMapper: AnimalDataToDomainMapper
) : AnimalRepository {

    override suspend fun fetchData(): Flow<BaseResult<List<AnimalModel>>> {

        return flow {
            if (networkHelper.isNetworkConnected()) {
                val response = apiServiceAnimal.fetchAnimals()
                if (response.isSuccessful) {
                    val bodyAnimal = response.body()!!
                    val animals = mutableListOf<AnimalModel>()

                    bodyAnimal.forEach {
                        animals.add(animalDataToDomainMapper.map(it))
                    }

                    emit(BaseResult.Success(animals))
                } else {
                    emit(BaseResult.Error(response.errorBody().toString()))
                }
            } else {
                emit(BaseResult.Error("No internet connection"))
            }
        }
    }
}