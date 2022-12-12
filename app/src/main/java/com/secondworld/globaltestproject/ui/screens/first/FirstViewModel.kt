package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.globaltestproject.core.bases.BaseViewModel
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

    private fun createListData() {
        val list = mutableListOf(
            Cat("Mursik"),
            Cat("Kesha"),
            Cat("Tomas"),
            Cat("Leopold"),
            Dog("Sharik"),
            Dog("Mars"),
            Dog("Bobik"),
            Dog("Malish"),
            Dog("Johan")
        )

        _dataAnimals.value = list
    }


}