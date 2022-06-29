package com.secondworld.globaltestproject.domain.repository

import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.ui.RecyclerViewItem

interface Repository {

    fun getRandomName() : String
    fun getRandomAge() : Int
    fun getListPersons() : MutableList<RecyclerViewItem>
}