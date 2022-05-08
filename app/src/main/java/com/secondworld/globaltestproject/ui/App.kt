package com.secondworld.globaltestproject.ui

import android.app.Application
import android.content.Context
import com.secondworld.globaltestproject.data.user.cache.room.AppDataBase
import com.secondworld.globaltestproject.data.user.cache.room.UserDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

class App : Application(){

    var userDao : UserDao? = null

    companion object{
        var INSTANCE : App? = null
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
        userDao = AppDataBase.getDatabase(this)?.userDao()
    }

    fun userDao() = userDao
}