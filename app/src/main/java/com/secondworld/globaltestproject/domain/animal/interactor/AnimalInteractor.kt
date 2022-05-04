package com.secondworld.globaltestproject.domain.animal.interactor

import com.secondworld.globaltestproject.domain.animal.AnimalRepository
import com.secondworld.globaltestproject.domain.animal.model.AnimalModel
import com.secondworld.globaltestproject.domain.common.BaseInteractor
import com.secondworld.globaltestproject.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimalInteractor @Inject constructor(private val animalRepository: AnimalRepository) : BaseInteractor<List<AnimalModel>> {
    override suspend fun get(): Flow<BaseResult<List<AnimalModel>>> {
        return animalRepository.fetchData()
    }
}