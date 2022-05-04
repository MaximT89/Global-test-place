package com.secondworld.globaltestproject.data.animals.remote.api

import com.secondworld.globaltestproject.data.animals.remote.dto.ResponseAnimal
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceAnimal {

    @GET("/animals/rand/10")
    suspend fun fetchAnimals() : Response<List<ResponseAnimal>>
}