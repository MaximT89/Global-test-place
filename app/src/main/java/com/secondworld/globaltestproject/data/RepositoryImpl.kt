package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val responseHandler: ResponseHandler,
) : Repository {

    override suspend fun fetchData(): ApiResult {

        return responseHandler.handlerResponse {
            apiService.getFox()
        }
    }
}