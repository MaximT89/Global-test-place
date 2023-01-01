package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.source.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val source: RemoteDataSource) {

    suspend fun getDogImage() = withContext(Dispatchers.IO) {
        source.getDogImage()
    }
}