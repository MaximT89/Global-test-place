package com.secondworld.globaltestproject.data.model

data class Cat(
    override val id : Int,
    val name: String,
    val isFavourite : Boolean = false
) : Animal