package com.secondworld.globaltestproject.domain.common

import kotlinx.coroutines.flow.Flow

interface BaseInteractor<out T : Any> {

    suspend fun get() : Flow<BaseResult<T>>
}