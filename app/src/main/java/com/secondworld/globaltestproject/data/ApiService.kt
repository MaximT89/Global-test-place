package com.secondworld.globaltestproject.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("floof")
    suspend fun getFox() : Response<ResponseFox>
}