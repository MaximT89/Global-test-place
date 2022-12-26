package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.extension.log
import com.secondworld.globaltestproject.data.MainInteractor
import com.secondworld.globaltestproject.data.MyWebSocketListener
import com.secondworld.globaltestproject.data.SocketUpdate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class FirstViewModel @Inject constructor(private val interactor: MainInteractor) : BaseViewModel() {

    private val _socketText = MutableLiveData("")
    val socketText : LiveData<String> = _socketText

    init {
        subscribeToSocketInEvents()
        subscribeToSocketOutEvents()
    }

    @ExperimentalCoroutinesApi
    fun subscribeToSocketInEvents() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                interactor.startSocketIn().consumeEach {
                    if (it.exception == null) {
                        _socketText.postValue(it.text)
                    } else {
                        onSocketError(it.exception)
                    }
                }
            } catch (ex: java.lang.Exception) {
                onSocketError(ex)
            }
        }
    }

    @ExperimentalCoroutinesApi
    fun subscribeToSocketOutEvents(text : String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                interactor.startSocketOut().consumeEach(SocketUpdate(text = text))
            } catch (ex: java.lang.Exception) {
                onSocketError(ex)
            }
        }
    }

    private fun onSocketError(ex: Throwable) {
        log(tag = "WEB_SOCKET", "Throwable: ${ex.message}")
        println("Error occurred : ${ex.message}")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCleared() {
        interactor.stopSocket()
        super.onCleared()
    }

}
