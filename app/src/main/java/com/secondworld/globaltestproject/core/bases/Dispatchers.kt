package com.secondworld.globaltestproject.core.bases

import kotlinx.coroutines.*
import javax.inject.Inject

interface Dispatchers {

    fun launchUI(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    suspend fun changeToUI(block: suspend CoroutineScope. () -> Unit)

    abstract class Abstract(
        private val ui: CoroutineDispatcher,
        private val background: CoroutineDispatcher,
    ) : Dispatchers {

        override fun launchUI(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit,
        ): Job = scope.launch(ui, block = block)

        override fun launchBackground(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit,
        ): Job = scope.launch(background, block = block)

        override suspend fun changeToUI(block: suspend CoroutineScope. () -> Unit) =
            withContext(ui, block)
    }

    class Impl @Inject constructor() :
        Abstract(kotlinx.coroutines.Dispatchers.Main, kotlinx.coroutines.Dispatchers.IO)
}