package com.secondworld.globaltestproject.domain.repository

import com.secondworld.globaltestproject.data.models.Person

interface Repository {

    fun getRandomName() : String
    fun getRandomAge() : Int
    fun getListPersons() : MutableList<Person>
}