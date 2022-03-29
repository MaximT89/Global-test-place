package com.secondworld.globaltestproject.data.api

import com.secondworld.globaltestproject.data.models.ResponseMemes
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/get_memes")
    suspend fun getMemes() : ResponseMemes

}