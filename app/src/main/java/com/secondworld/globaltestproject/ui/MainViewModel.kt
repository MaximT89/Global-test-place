package com.secondworld.globaltestproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.data.user.cache.room.UserEntity
import com.secondworld.globaltestproject.domain.user.UserInteractor
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userInteractor: UserInteractor) : ViewModel() {

    private var _users = MutableSharedFlow<List<UserEntity>>()
    val users : SharedFlow<List<UserEntity>> = _users

    fun getUsers() {
        viewModelScope.launch {
            _users.emit(userInteractor.getUsers()!!)
        }
    }

    fun insertUser(user : UserEntity){
        viewModelScope.launch {
            userInteractor.insertUser(user)
        }
    }

    fun cleanUsers(){
        viewModelScope.launch {
            userInteractor.dropTable()
            _users.emit(userInteractor.getUsers()!!)
        }
    }
}