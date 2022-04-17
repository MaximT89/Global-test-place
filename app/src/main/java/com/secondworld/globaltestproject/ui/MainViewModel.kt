package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.*
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase

class MainViewModel(
    private val personUseCase: PersonUseCase,
    private val resourceProvider: ResourceProvider
) : BaseViewModel(resourceProvider) {

    private var _listPerson = MutableLiveData<MutableList<Person>?>()
    val listPerson: LiveData<MutableList<Person>?> = _listPerson

    val mlv = MutableLiveData<String>()
    val str: String? = null
    fun testFun(){
        mlv.value = str
    }

    fun getPerson() {
        _listPerson.value = personUseCase.getListPerson()
        resourceProvider.string(R.string.test_string)
    }

    fun removePerson(position: Int) = removeItem(position, _listPerson)
    fun upElement(position: Int) = upItem(position, _listPerson)
    fun downElement(position: Int) = downItem(position, _listPerson)

}