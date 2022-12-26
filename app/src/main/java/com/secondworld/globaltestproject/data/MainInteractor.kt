package com.secondworld.globaltestproject.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class MainInteractor @Inject constructor(private val repository: MainRepository) {

    @ExperimentalCoroutinesApi
    fun stopSocket() {
        repository.closeSocket()
    }

    @ExperimentalCoroutinesApi
    fun startSocketIn(): Channel<SocketUpdate> = repository.startSocketIn()

    @ExperimentalCoroutinesApi
    fun startSocketOut(): Channel<SocketUpdate> = repository.startSocketOut()

}

class MainRepository @Inject constructor(private val webServicesProvider: WebSocketProvider) {

    @ExperimentalCoroutinesApi
    fun startSocketIn(): Channel<SocketUpdate> =
        webServicesProvider.startSocketIn()

    @ExperimentalCoroutinesApi
    fun startSocketOut(): Channel<SocketUpdate> =
        webServicesProvider.startSocketOut()

    @ExperimentalCoroutinesApi
    fun closeSocket() {
        webServicesProvider.stopSocket()
    }
}