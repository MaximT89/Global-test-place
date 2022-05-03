package com.secondworld.globaltestproject.domain

import com.secondworld.globaltestproject.data.ApiResult
import javax.inject.Inject

interface BaseInteractor<T> {

    suspend fun get(): T

    class Base @Inject constructor(private val repository: Repository) : BaseInteractor<ApiResult> {
        override suspend fun get(): ApiResult {
            val response = repository.fetchData()
            return if (response.isSuccessful){
                ApiResult.Success(response)
            } else {
                ApiResult.Error("some troubles")
            }
        }
    }
}