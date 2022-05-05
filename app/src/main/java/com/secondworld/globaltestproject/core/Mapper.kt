package com.secondworld.globaltestproject.core

interface Mapper<S, T> {

    fun map(data : S) : T
}