package com.secondworld.globaltestproject.data.storages

import javax.inject.Inject

class StorageName @Inject constructor() {

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
}