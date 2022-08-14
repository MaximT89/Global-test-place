package com.secondworld.globaltestproject.ui

sealed class Result<T, S>(val data1: T, val data2: S) : MapperOne, MapperTwo {


    class One(
        val persom: Persom,
        val animal: Animal,
    ) : Result<Persom, Animal>(Persom(), Animal()) {

        override fun map(data: Int) {
            TODO("Not yet implemented")
        }

        override fun map(data: String) {
            TODO("Not yet implemented")
        }
    }



    class Two : Result() {
        override fun map(data: String) {
            TODO("Not yet implemented")
        }

    }
}