package com.secondworld.globaltestproject.logic

open class Empty(override val name: String) : PrintName

open class Animal(name: String) : Empty(name)

class Tiger(name: String) : Animal(name)