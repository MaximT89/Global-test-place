package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.data.socket.MessageListener
import com.secondworld.globaltestproject.data.socket.WebSocketManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val webSocketManager: WebSocketManager
) : BaseViewModel(), MessageListener {

    private val _messageFromSocket = MutableLiveData<String?>()
    val messageFromSocket : LiveData<String?> = _messageFromSocket

    private val _messageInfo = MutableLiveData<String?>()
    val messageInfo : LiveData<String?> = _messageInfo

    init {
       initSocket()
    }

    fun sendMessageToSocket(message: String) {
        if (webSocketManager.sendMessage(message)) {
            log(message = "message send success")
        } else {
            log(message = "message send fail")
        }
    }


    fun connectWebSocket() {
        webSocketManager.connect()
    }

    private fun initSocket() {
        webSocketManager.init(this)
    }

    override fun onConnectSuccess() {
        _messageInfo.postValue("onConnectSuccess")
    }

    override fun onConnectFailed() {
        _messageInfo.postValue("onConnectFailed")
    }

    override fun onClose() {
        _messageInfo.postValue("onClose")
        webSocketManager.close()
    }

    override fun onMessage(text: String?) {
        _messageFromSocket.postValue(text)
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.close()
    }
}
