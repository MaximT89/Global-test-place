package com.secondworld.globaltestproject.data.socket

interface MessageListener {
    fun onConnectSuccess()      // successfully connected
    fun onConnectFailed()       // connection failed
    fun onClose()               // close
    fun onMessage(text: String?)
}