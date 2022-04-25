package com.secondworld.globaltestproject.data.storage

import com.secondworld.globaltestproject.data.model.User
import javax.inject.Inject

class UserStorage @Inject constructor() {

    fun getUsers() : List<User> = mutableListOf<User>().apply{
        repeat(10){
            add(User(getName()))
        }
    }

    private fun getName() = listOf(
        "Max",
        "Peter",
        "Sara",
        "Ann",
        "Mike"
    ).random()
}