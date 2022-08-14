package com.secondworld.globaltestproject.ui

interface MapperOne {

    fun map(data : Int)

    class Base : MapperOne{
        override fun map(data: Int) {
            println(data.toString())
        }

    }
}