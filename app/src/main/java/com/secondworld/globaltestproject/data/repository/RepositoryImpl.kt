package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.domain.models.Animals
import com.secondworld.globaltestproject.domain.repository.Repository

class RepositoryImpl(private val storageName : StorageName) : Repository {

    override fun randomAge() = (1..10).random()

    override fun randomName() = storageName.getName()

    override fun generateAnimals(): MutableList<Animals> {
        val mutableList = mutableListOf<Animals>()
        repeat((0..100).count()) {
            when(randomAnimalType()){
                1 -> mutableList.add(Animals.Cat(randomAge(), randomName()))
                2 -> mutableList.add(Animals.Dog(randomAge(), randomName()))
                3 -> mutableList.add(Animals.Bird(randomAge(), randomName()))
            }
        }
        return mutableList
    }

    override fun randomAnimalType() = (1..3).random()
}