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

    private var _usersState = MutableLiveData<UserState>()
    val usersState: LiveData<UserState> = _usersState

    private var _listPerson = MutableLiveData<List<Person>?>()
    val listPerson: LiveData<List<Person>?> = _listPerson

    private var _checkActive = MutableLiveData(false)
    val checkActive: LiveData<Boolean> = _checkActive

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

    fun cancelActiveUser() {
        _listPerson.value.let { persons ->
            _listPerson.value = persons?.map {
                if (it.isActive) it.copy(isActive = false)
                else it.copy()
            }
        }
    }

    private fun startState(state: UserState) {
        _usersState.value = state
    }

    fun checkUser(active: Boolean) {
        if (active) {
            _checkActive.value = true
            startState(UserState.CheckUsers)
        } else {
            _checkActive.value = false
            startState(UserState.NormalState)
        }
    }

    fun deleteCheckedUsers() {
        val list : MutableList<Person>? = _listPerson.value?.toMutableList()
        list?.removeAll { it.isActive }
        _listPerson.value = list
    }
}

sealed class UserState {
    object CheckUsers : UserState()
    object NormalState : UserState()
}