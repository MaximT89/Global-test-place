package com.secondworld.globaltestproject.data.storages

class StorageDataPersons {

    fun name() = listOf(
        "Max",
        "Peter",
        "Tony",
        "Ann",
        "Sara",
        "Mary"
    ).random()

    fun age() = (15..70).random()

    fun phone() = "+7 (${(900..960).random()}) ${(100..999).random()} - ${(10..99)} - ${(10..99)}"
}