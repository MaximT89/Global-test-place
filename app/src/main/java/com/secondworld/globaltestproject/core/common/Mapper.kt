package com.secondworld.globaltestproject.core.common

interface Mapper<T, R> {

    fun map(data : T) : R
}