package com.secondworld.globaltestproject.data.source

import com.secondworld.globaltestproject.core.bases.BaseResult
import com.secondworld.globaltestproject.core.remote.Failure
import com.secondworld.globaltestproject.core.remote.ResponseWrapper
import com.secondworld.globaltestproject.data.model.ResponseDogImage
import com.secondworld.globaltestproject.data.remote.DogService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: DogService,
    private val responseWrapper: ResponseWrapper,
) {

    suspend fun getDogImage(): BaseResult<ResponseDogImage, Failure> =
        responseWrapper.handleResponse {
            api.getImageDog()
        }
}