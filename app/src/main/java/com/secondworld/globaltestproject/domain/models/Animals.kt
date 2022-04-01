package com.secondworld.globaltestproject.domain.models

sealed class Animals {
    data class Dog(var age: Int, var name: String) : Animals()
    data class Cat(var age: Int, var name: String) : Animals()
    data class Bird(var age: Int, var name: String) : Animals()
}
