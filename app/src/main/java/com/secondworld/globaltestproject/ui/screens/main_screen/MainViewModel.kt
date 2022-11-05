package com.secondworld.globaltestproject.ui.screens.main_screen

import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.bases.Dispatchers
import com.secondworld.globaltestproject.data.local.room.UserDao
import com.secondworld.globaltestproject.data.local.room.UserEntity
import com.secondworld.globaltestproject.domain.main_screen.MainInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchers: Dispatchers,
    private val mainInteractor: MainInteractor,
    private val dao: UserDao,
) : BaseViewModel() {

    private val _users = MutableSharedFlow<List<UserEntity>>()
    val users: SharedFlow<List<UserEntity>> = _users

    init {
        getItemsFromDb()
        getNewTenItems()
    }

    private fun getItemsFromDb(){
        dispatchers.launchBackground(viewModelScope) {
            mainInteractor.getUsers().collect(){ list ->
                _users.emit(list)
            }
        }
    }

    fun getNewTenItems() {
        dispatchers.launchBackground(viewModelScope) {
            val items = mainInteractor.generateNewTenItems()
            for (item in items) {
                dao.insertUser(item)
            }
        }
    }

    fun clearTable() {
        dispatchers.launchBackground(viewModelScope){
            mainInteractor.clearTable()
        }
    }

    fun deleteItem(id: Int) {
        dispatchers.launchBackground(viewModelScope){
            mainInteractor.deleteItemFromDb(id)
        }
    }
}