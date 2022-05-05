package com.secondworld.globaltestproject.core

interface Mapper<T, S> {

    fun map(data : T) : S
}