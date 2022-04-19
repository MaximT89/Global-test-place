package com.secondworld.globaltestproject.core

abstract class Abstract {

    interface Mapper {

        interface Data<S, R> : Mapper {
            fun map(data: S): R
        }
    }
}

