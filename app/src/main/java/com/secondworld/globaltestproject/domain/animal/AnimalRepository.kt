package com.secondworld.globaltestproject.domain.animal

import com.secondworld.globaltestproject.domain.animal.model.AnimalModel
import com.secondworld.globaltestproject.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow

interface AnimalRepository{

    suspend fun fetchData() : Flow<BaseResult<List<AnimalModel>>>
}