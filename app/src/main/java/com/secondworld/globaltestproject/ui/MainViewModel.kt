package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.core.downItem
import com.secondworld.globaltestproject.core.removeItem
import com.secondworld.globaltestproject.core.upItem
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val personUseCase: PersonUseCase) : ViewModel() {

    private var _listPerson = MutableLiveData<MutableList<Person>?>()
    val listPerson: LiveData<MutableList<Person>?> = _listPerson

    fun getPerson() {
        _listPerson.value = personUseCase.getListPerson()
    }

    fun removePerson(position: Int) = removeItem(position, _listPerson)
    fun upElement(position: Int) = upItem(position, _listPerson)
    fun downElement(position: Int) = downItem(position, _listPerson)
}