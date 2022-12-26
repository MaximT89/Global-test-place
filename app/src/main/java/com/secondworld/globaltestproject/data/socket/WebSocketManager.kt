package com.secondworld.globaltestproject.data.socket

import com.secondworld.globaltestproject.core.extension.log
import okhttp3.*
import okio.ByteString
import javax.inject.Inject

class WebSocketManager @Inject constructor(
    private val client: OkHttpClient,
    private val request: Request
) {

    private val MAX_NUM = 5  // Maximum number of reconnections
    private val MILLIS = 5000  // Reconnection interval, milliseconds
    private var connectNum = 0
    private var isConnect = false

    private var messageListener: MessageListener? = null
    private var mWebSocket: WebSocket? = null

    fun init(_messageListener: MessageListener) {

        // TODO: под вопросом инициализация
        messageListener = _messageListener
    }

    fun connect() {
        if (isConnect()) {
            log("web socket connected")
            return
        }
        client.newWebSocket(request, createListener())
    }

    fun reconnect() {
        log(message = "Start Reconnect")
        if (connectNum <= MAX_NUM) {
            try {
                Thread.sleep(MILLIS.toLong())
                connect()
                connectNum++
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        } else {
            log("reconnect over $MAX_NUM,please check url or network")
        }
    }

    fun sendMessage(text: String): Boolean {
        return if (!isConnect()) false else mWebSocket?.send(text) == true
    }

    fun sendMessage(byteString: ByteString): Boolean {
        return if (!isConnect()) false else mWebSocket?.send(byteString) == true
    }

    fun close() {
        if (isConnect()) {
            mWebSocket?.cancel()
            mWebSocket?.close( 1001 , "The client actively closes the connection " )
        }
    }

    private fun isConnect(): Boolean {
        return isConnect
    }

    private fun createListener(): WebSocketListener {
        return object : WebSocketListener() {
            override fun onOpen(
                webSocket: WebSocket,
                response: Response
            ) {
                super.onOpen(webSocket, response)
                log("open:$response")
                mWebSocket = webSocket
                isConnect = response.code == 101
                if (!isConnect) {
                    reconnect()
                } else {
                    log("connect success.")
                    messageListener?.onConnectSuccess()
                }
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                messageListener?.onMessage(text)
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                super.onMessage(webSocket, bytes)
                messageListener?.onMessage(bytes.base64())
            }

            override fun onClosing(
                webSocket: WebSocket,
                code: Int,
                reason: String
            ) {
                super.onClosing(webSocket, code, reason)
                log("connect onClosing.")

                isConnect = false
                messageListener?.onClose()
            }

            override fun onClosed(
                webSocket: WebSocket,
                code: Int,
                reason: String
            ) {
                super.onClosed(webSocket, code, reason)
                log("connect onClosed.")

                isConnect = false
                messageListener?.onClose()
            }

            override fun onFailure(
                webSocket: WebSocket,
                t: Throwable,
                response: Response?
            ) {
                super.onFailure(webSocket, t, response)
                log("connect onFailure.")

                if (response != null) {
                    log("connect failed：" + response.message)
                }
                log("connect failed throwable：" + t.message)
                isConnect = false
                messageListener?.onConnectFailed()
                reconnect()
            }
        }
    }
}