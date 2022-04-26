package com.secondworld.globaltestproject.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

interface Communication<T> : Mutable<T> {

    abstract class UiUpdate<T : Any> : Communication<T>{

        private val mutableLiveData : MutableLiveData<T> = MutableLiveData()

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            mutableLiveData.observe(owner, observer)
        }

        override fun map(data: T) {
            mutableLiveData.value = data
        }
    }

    abstract class PostUpdate<T : Any> : Communication<T>{

        private val mutableLiveData : MutableLiveData<T> = MutableLiveData()

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            mutableLiveData.observe(owner, observer)
        }

        override fun map(data: T) {
            mutableLiveData.postValue(data)
        }
    }
}

interface Observe<T>{
    fun observe(owner : LifecycleOwner, observer: Observer<T>)
}

interface Update<T>{
    fun map(data : T)
}

interface Mutable<T> : Observe<T>, Update<T>