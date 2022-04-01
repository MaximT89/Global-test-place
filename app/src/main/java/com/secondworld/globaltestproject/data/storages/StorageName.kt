package com.secondworld.globaltestproject.data.storages

class StorageName {
    fun getName() = mutableListOf<String>().apply {
        add("Charly")
        add("Mike")
        add("Percy")
        add("Shone")
        add("Sara")
    }.random()
}