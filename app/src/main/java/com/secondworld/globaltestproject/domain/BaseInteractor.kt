package com.secondworld.globaltestproject.domain

interface BaseInteractor<T> {

    fun get() : T

    class Base(private val repository: Repository) : BaseInteractor<BaseModel>{
        override fun get(): BaseModel {
            TODO("Not yet implemented")
        }
    }
}