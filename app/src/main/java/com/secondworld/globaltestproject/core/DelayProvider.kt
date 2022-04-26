package com.secondworld.globaltestproject.core

import kotlinx.coroutines.delay

interface DelayProvider {

    suspend fun provideDelay()

    class Base : DelayProvider {

        private val time = 10000L

        override suspend fun provideDelay() = delay(time)
    }
}