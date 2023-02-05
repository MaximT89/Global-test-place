package com.secondworld.globaltestproject.ui.screens.first

import com.secondworld.globaltestproject.ui.screens.first.Dog as Dog

interface Animals

class Dog : Animals

class Cat : Animals

class AnimalAbstract{
    fun <T> getSound(){
        when(T::class){
            Cat::class -> println("sound cat...")
            Dog::class -> println("sound dog...")
            else -> throw Exception("unknown animal...")
        }
    }
}