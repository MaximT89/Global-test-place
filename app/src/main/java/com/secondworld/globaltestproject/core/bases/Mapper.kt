package com.secondworld.globaltestproject.core.bases

interface Mapper<T, R> {

    fun map(data : T) : R
}