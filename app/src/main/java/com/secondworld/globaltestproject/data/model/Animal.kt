package com.secondworld.globaltestproject.data.model

import com.secondworld.globaltestproject.core.recycler.Match

data class Animal(
    val id : Int,
    val name : String,
    val age : Int
) : Match<Animal> {
    override fun matches(model: Animal): Boolean {
        return model == this
    }

    override fun matchesId(model: Animal): Boolean {
        return model.id == this.id
    }
}