package com.secondworld.globaltestproject.data

import androidx.datastore.preferences.protobuf.ByteString
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.data.WebSocketProvider.Companion.NORMAL_CLOSURE_STATUS
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

@OptIn(DelicateCoroutinesApi::class)
@ExperimentalCoroutinesApi
class MyWebSocketListener : WebSocketListener() {

    val socketEventChannelIn: Channel<SocketUpdate> = Channel(10)
    val socketEventChannelOut: Channel<SocketUpdate> = Channel(10)

    override fun onMessage(webSocket: WebSocket, text: String) {

        GlobalScope.launch {
            socketEventChannelIn.send(SocketUpdate(text))
        }

        GlobalScope.launch {
            webSocket.send(socketEventChannelOut.receive().toString())
        }

    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {

        log(tag = "WEB_SOCKET", "Web Socket is Closing")

        GlobalScope.launch {
            socketEventChannelIn.send(SocketUpdate(exception = SocketAbortedException()))
            socketEventChannelOut.send(SocketUpdate(exception = SocketAbortedException()))
        }
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        socketEventChannelIn.close()
        socketEventChannelOut.close()
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {

        log(tag = "WEB_SOCKET", "Web Socket is onFailure")

        GlobalScope.launch {
            socketEventChannelIn.send(SocketUpdate(exception = t))
        }

        GlobalScope.launch {
            socketEventChannelOut.send(SocketUpdate(exception = t))
        }
    }

}

class SocketAbortedException : Exception()

data class SocketUpdate(
    val text: String? = null,
    val byteString: ByteString? = null,
    val exception: Throwable? = null
)