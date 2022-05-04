package com.secondworld.globaltestproject.domain.common

sealed class BaseResult<out T : Any>{
    data class Success<T : Any> (val data : T) : BaseResult<T>()
    data class Error(val errorMessage: String) : BaseResult<Nothing>()
}