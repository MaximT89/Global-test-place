package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.data.remote.CloudDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val cloudDataSource: CloudDataSource) {

    suspend fun getImage() = cloudDataSource.getImage()
}