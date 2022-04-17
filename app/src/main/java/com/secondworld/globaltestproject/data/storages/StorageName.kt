package com.secondworld.globaltestproject.data.storages

import javax.inject.Inject

class StorageName @Inject constructor(){
    fun getName() = mutableListOf<String>().apply {
        add("Charly")
        add("Mike")
        add("Percy")
        add("Shone")
        add("Sara")
    }.random()
}