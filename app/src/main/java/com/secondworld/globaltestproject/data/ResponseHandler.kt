package com.secondworld.globaltestproject.data

import retrofit2.Response
import javax.inject.Inject

interface ResponseHandler {

    suspend fun <T> handlerResponse(
        apiCall: suspend () -> Response<T>,
    ): ApiResult

    class Base @Inject constructor(private val networkHelper: NetworkHelper) : ResponseHandler {

        override suspend fun <T> handlerResponse(apiCall: suspend () -> Response<T>): ApiResult {
            if (networkHelper.isNetworkConnected()) {
                try {
                    val response = apiCall()
                    val body = response.body()
                    if (response.isSuccessful && body != null) {
                        return ApiResult.Success(response)
                    }
                    return ApiResult.Error(response.errorBody().toString())
                } catch (e: Exception) {
                    return ApiResult.Error(e.printStackTrace().toString())
                }
            } else {
                return ApiResult.Error("No internet connection")
            }
        }
    }
}