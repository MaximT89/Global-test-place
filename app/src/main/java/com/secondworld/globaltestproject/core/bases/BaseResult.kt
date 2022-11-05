package com.secondworld.globaltestproject.core.bases

/**
 * Класс, который используется для приема ответа успешного или приема ошибки
 */
sealed class BaseResult<out T, out R> {
    class Success<T>(val data: T) : BaseResult<T, Nothing>()
    class Error<R>(val err: R) : BaseResult<Nothing, R>()
}