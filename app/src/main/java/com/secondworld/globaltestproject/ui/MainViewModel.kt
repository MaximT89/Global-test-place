package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.core.downItem
import com.secondworld.globaltestproject.core.upItem
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

    fun upElement(position: Int) {
        _listPerson.value = upItem(position, _listPerson)

//        if (position != 0){
//            val persons = _listPerson.value
//            val personTemp = persons?.get(position)
//            persons?.removeAt(position)
//            persons?.add(position.dec(), personTemp!!)
//            _listPerson.value = persons
//        }
    }

    fun downElement(position: Int) {
        _listPerson.value = downItem(position, _listPerson)

//        if (position != _listPerson.value?.size?.minus(1)){
//            val persons = _listPerson.value
//            val personTemp = persons?.get(position)
//            persons?.removeAt(position)
//            persons?.add(position.inc(), personTemp!!)
//            _listPerson.value = persons
//        }
    }
}