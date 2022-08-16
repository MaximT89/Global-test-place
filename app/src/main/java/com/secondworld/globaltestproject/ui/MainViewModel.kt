package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val personUseCase: PersonUseCase) : ViewModel() {

    private var _listPerson = MutableLiveData<List<Person>>()
    val listPerson: LiveData<List<Person>> = _listPerson

    init {
        getPerson()
    }

    private fun getPerson() {
        _listPerson.value = personUseCase.getListPerson()
    }

    fun changeActivePerson(id: Int) {
        _listPerson.value.let { persons ->
            _listPerson.value = persons?.map {
                if (it.id == id) it.copy(isActive = !it.isActive)
                else it.copy()
            }
        }
    }
}