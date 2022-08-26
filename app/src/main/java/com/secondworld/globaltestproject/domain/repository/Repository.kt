package com.secondworld.globaltestproject.domain.repository

import com.secondworld.globaltestproject.data.models.Person

interface Repository {

    fun getRandomId() : Int
    fun getListPersons() : MutableList<Person>
}