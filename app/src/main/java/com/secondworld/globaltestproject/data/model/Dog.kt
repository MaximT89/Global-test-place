package com.secondworld.globaltestproject.data.model

data class Dog(
    override val id: Int,
    val name: String,
) : Animal