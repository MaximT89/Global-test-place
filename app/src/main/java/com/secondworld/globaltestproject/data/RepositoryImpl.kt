package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {

    override suspend fun fetchData(): Response<ResponseFox> {
        return apiService.getFox()
    }
}