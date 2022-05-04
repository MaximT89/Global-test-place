package com.secondworld.globaltestproject.core

interface Mapper<S : Any,T : Any> {

    fun map(data : S) : T
}