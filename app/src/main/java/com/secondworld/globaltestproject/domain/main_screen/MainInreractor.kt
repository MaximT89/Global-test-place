package com.secondworld.globaltestproject.domain.main_screen

import com.secondworld.globaltestproject.data.local.room.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainInteractor @Inject constructor(private val repository : Repository) {

    fun getUsers() = repository.getUsers()

    suspend fun deleteItemFromDb(id : Int) {
        repository.deleteUser(id)
    }

    fun generateNewTenItems() : List<UserEntity> {
        val list = mutableListOf<UserEntity>()
        for (i in 0..10){
            list.add(UserEntity(0, generateNewName(), generateNewAge()))
        }
        return list
    }

    private fun generateNewName() : String {
        return listOf("Max", "Tony", "Mike", "Tomas", "Nikita", "John").random()
    }

    private fun generateNewAge() : Int {
        return (10..50).random()
    }

    suspend fun clearTable() {
        repository.dropTable()
    }
}