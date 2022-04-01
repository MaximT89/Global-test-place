package com.secondworld.globaltestproject.domain.repository

import com.secondworld.globaltestproject.domain.models.Animals

interface Repository {

    fun randomAge() : Int
    fun randomName() : String
    fun generateAnimals() : MutableList<Animals>
}