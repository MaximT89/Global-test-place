package com.secondworld.globaltestproject.domain.models

sealed class Animals {
    class Dog(var age: Int, var name: String) : Animals()
    class Cat(var age: Int, var name: String) : Animals()
    class Bird(var age: Int, var name: String) : Animals()
}
