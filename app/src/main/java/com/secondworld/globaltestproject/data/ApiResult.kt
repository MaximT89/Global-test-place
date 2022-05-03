package com.secondworld.globaltestproject.data

sealed class ApiResult{
    class Success<out T>(val data : T) : ApiResult()
    class Error(val message : String) : ApiResult()
    object Empty : ApiResult()
}
