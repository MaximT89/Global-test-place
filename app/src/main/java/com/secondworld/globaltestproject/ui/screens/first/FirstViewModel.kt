package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.extension.newListMain
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.data.model.Cat
import com.secondworld.globaltestproject.data.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor() : BaseViewModel() {


    private val _dataAnimals = MutableLiveData<List<Animal>>(emptyList())
    val dataAnimals: LiveData<List<Animal>> = _dataAnimals

    init {
        createListData()
    }

    fun filterData() {
        val newData = _dataAnimals.value?.filter {
            when (it) {
                is Dog -> it.name.startsWith("B")
                is Cat -> it.name.startsWith("T")
                else -> throw Exception("unknown animal")
            }
        }

        _dataAnimals.value = newData!!
    }

    private fun createListData() {
        val list = mutableListOf(
            Cat(1,"Mursik"),
            Cat(2,"Kesha"),
            Cat(3,"Tomas"),
            Cat(4,"Leopold"),
            Dog(5,"Sharik"),
            Dog(6,"Mars"),
            Dog(7,"Bobik"),
            Dog(8,"Malish"),
            Dog(9,"Johan")
        )

        _dataAnimals.value = list
    }


}