package com.secondworld.globaltestproject.ui

import android.os.Build
import androidx.lifecycle.*
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.core.newList
import com.secondworld.globaltestproject.core.newListMain
import com.secondworld.globaltestproject.data.Profession
import com.secondworld.globaltestproject.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _listPersons = MutableLiveData<List<PersonItem?>?>()
    val listPersons: LiveData<List<PersonItem?>?> = _listPersons

    private val _listChips = MutableLiveData<List<Profession>>()
    val listChips: LiveData<List<Profession>> = _listChips

    private val _listChipsFilter = MutableLiveData<MutableList<Profession>?>(mutableListOf())
    val listChipsFilter: LiveData<MutableList<Profession>?> = _listChipsFilter

    init {
        getPersonsFromServer()
        getChips()
    }

    fun getFilteredListPerson(list: MutableList<Profession>?) {

        val list = _listPersons.value

        list?.filter { it?.professions!!.contains(Profession.ARTIST) }
        _listPersons.value = list
        _listPersons.newListMain { it?.copy() }

    }

    fun filterProfessionItems(profession: Profession, statusAdd: Boolean) {
        val list = _listChipsFilter.value
        if (statusAdd) list!!.add(profession)
        else list!!.remove(profession)
        _listChipsFilter.value = list
    }

    fun getChips() {
        _listChips.value = listOf(
            Profession.DOCTOR,
            Profession.DRIVER,
            Profession.HR,
            Profession.LAWYER,
            Profession.IT,
            Profession.COURIER,
            Profession.ARTIST
        )
    }

    fun getPersonsFromServer() {
        _listPersons.value = repository.getPersons()
    }

}