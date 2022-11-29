package com.secondworld.globaltestproject.data.remote

import com.secondworld.globaltestproject.core.bases.BaseResult
import com.secondworld.globaltestproject.core.remote.Failure
import com.secondworld.globaltestproject.core.remote.ResponseWrapper
import javax.inject.Inject

class CloudDataSource @Inject constructor(
    private val responseWrapper: ResponseWrapper,
    private val api: ImageLoaderApi
) {

    suspend fun getImage(): BaseResult<ResponseImageLoad, Failure> =
        responseWrapper.handleResponse {
            api.getImageFromServer()
        }
}