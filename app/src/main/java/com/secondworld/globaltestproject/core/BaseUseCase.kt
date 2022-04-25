package com.secondworld.globaltestproject.core

interface BaseUseCase<T, S> {
    fun get(repository: S) : T
}