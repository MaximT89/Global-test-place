package com.secondworld.globaltestproject.data

import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("comments")
    suspend fun getData(): Response<List<ResponseNew>>

}