package com.secondworld.globaltestproject.domain

import com.secondworld.globaltestproject.data.ResponseFox
import retrofit2.Response

interface Repository{

    suspend fun fetchData() : Response<ResponseFox>
}