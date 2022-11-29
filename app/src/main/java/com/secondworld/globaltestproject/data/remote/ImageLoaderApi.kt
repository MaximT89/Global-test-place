package com.secondworld.globaltestproject.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ImageLoaderApi {

    @GET("api/breeds/image/random")
    suspend fun getImageFromServer() : Response<ResponseImageLoad>
}