package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.core.remote.ResponseWrapper
import com.secondworld.globaltestproject.data.remote.api.PostApi
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: PostApi,
    private val responseWrapper: ResponseWrapper,
) {

    suspend fun getPost() = responseWrapper.handleResponse {
        api.getPost()
    }

}