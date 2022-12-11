package com.secondworld.globaltestproject.data.remote.api

import com.secondworld.globaltestproject.data.remote.model.ResponsePost
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts/1")
    suspend fun getPost() : Response<ResponsePost>
}