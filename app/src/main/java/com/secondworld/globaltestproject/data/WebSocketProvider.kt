package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.data.SocketServerUrl.SOCKET_URL

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class WebSocketProvider @Inject constructor() {

    private var _webSocket: WebSocket? = null

    private val socketOkHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(39, TimeUnit.SECONDS)
        .hostnameVerifier { _, _ -> true }
        .build()

    private var _webSocketListener: MyWebSocketListener? = null

    fun startSocketIn(): Channel<SocketUpdate> {
        return with(MyWebSocketListener()) {
            startSocket(this)
            this@with.socketEventChannelIn
        }
    }

    fun startSocketOut(): Channel<SocketUpdate> =
        with(MyWebSocketListener()) {
            startSocket(this)
            this@with.socketEventChannelOut
        }

    private fun startSocket(webSocketListener: MyWebSocketListener) {
        _webSocketListener = webSocketListener
        _webSocket = socketOkHttpClient.newWebSocket(
            Request.Builder().url(SOCKET_URL).build(),
            webSocketListener
        )
        socketOkHttpClient.dispatcher.executorService.shutdown()
    }

    fun stopSocket() {
        try {
            _webSocket?.close(NORMAL_CLOSURE_STATUS, null)
            _webSocket = null
            _webSocketListener?.socketEventChannelIn?.close()
            _webSocketListener = null
        } catch (ex: Exception) {
        }
    }

    companion object {
        const val NORMAL_CLOSURE_STATUS = 1000
    }
}