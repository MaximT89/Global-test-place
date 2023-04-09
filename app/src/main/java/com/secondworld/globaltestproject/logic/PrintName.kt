package com.secondworld.globaltestproject.logic

import com.secondworld.globaltestproject.core.extension.log

interface PrintName {
    val name: String
    fun printName() {
        log("Name", "${this.javaClass.simpleName} and name: $name")
    }
}