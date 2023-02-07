package com.secondworld.globaltestproject.data.storages

import javax.inject.Inject

class UserStorage @Inject constructor() {

    fun listNames() : MutableList<String> = mutableListOf(
        "Max",
        "Sara",
        "Tom",
        "Peter",
        "Tony",
        "Shone",
        "John",
        "Mike",
        "Nick",
        "Nikita",
        "Luci",
        "Paola",
        "Maria",
        "Ann"
    )

    fun listProfessions() : MutableList<String> = mutableListOf(
        "Poet",
        "Trader",
        "Teacher",
        "PA",
        "HR",
        "Android Developer",
        "Doctor",
        "Driver",
        "Farmer",
        "Tutor",
        "Builder",
        "Artist",
        "Carpenter",
        "Waiter"
    )
}