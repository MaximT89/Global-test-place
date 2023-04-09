package com.secondworld.globaltestproject.logic

interface HandlerOut<out T> {
    fun nextT() : T
}

interface HandlerIn<in T> {
    fun compareTo(other : T): Animal
}