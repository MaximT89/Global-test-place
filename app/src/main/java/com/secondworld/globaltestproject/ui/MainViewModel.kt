package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase

class MainViewModel(private val personUseCase: PersonUseCase) : ViewModel() {

    private var _listPerson = MutableLiveData<MutableList<Person>?>()
    val listPerson : LiveData<MutableList<Person>?> = _listPerson

    fun getPerson() {
        _listPerson.value = personUseCase.getListPerson()
    }

    fun removePerson(position : Int) {
        val persons = _listPerson.value
        persons?.removeAt(position)
        _listPerson.value = persons
    }



}