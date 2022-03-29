package com.secondworld.globaltestproject.data.api

sealed class ApiState {
    object Empty : ApiState()
    object Loading : ApiState()
    class Success<T>(val data: T?) : ApiState()
    class Error(msg: String) : ApiState()
}
