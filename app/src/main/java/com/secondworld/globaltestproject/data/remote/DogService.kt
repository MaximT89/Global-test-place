package com.secondworld.globaltestproject.data.remote

import com.secondworld.globaltestproject.data.model.ResponseDogImage
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET("api/breeds/image/random")
    suspend fun getImageDog() : Response<ResponseDogImage>
}