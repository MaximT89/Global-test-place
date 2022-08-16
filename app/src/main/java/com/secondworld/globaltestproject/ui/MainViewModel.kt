package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val personUseCase: PersonUseCase) : ViewModel() {

    private var _listPerson = MutableLiveData<MutableList<Person>?>()
    val listPerson: LiveData<MutableList<Person>?> = _listPerson

    init {
        getPerson()
    }

    fun getPerson() {
        _listPerson.value = personUseCase.getListPerson()
    }

    fun changeActivePerson(id: Int) {
        log("id = $id")
        val list = _listPerson.value
        list?.forEach { person ->
            if (person.id == id) {
                person.isActive = !person.isActive
            }
        }
        _listPerson.value = list
    }
}