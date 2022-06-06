package com.secondworld.globaltestproject.core

interface Mapper<T, R> {

    fun map(data : T) : R
}