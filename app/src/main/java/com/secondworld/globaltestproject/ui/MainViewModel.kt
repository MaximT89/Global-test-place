package com.secondworld.globaltestproject.ui

import androidx.lifecycle.*
import com.secondworld.globaltestproject.data.Profession
import com.secondworld.globaltestproject.data.Repository
import com.secondworld.globaltestproject.ui.model.PersonItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _listPersons = MutableLiveData<MutableList<PersonItem>?>(mutableListOf())
    val listPersons: LiveData<MutableList<PersonItem>?> = _listPersons

    private val _listChips = MutableLiveData<List<Profession>>()
    val listChips: LiveData<List<Profession>> = _listChips

    private val _filterChips = MutableLiveData(mutableListOf<Profession>())
    val filterChips: LiveData<MutableList<Profession>> = _filterChips

    private val _filterStart = MutableLiveData(false)
    val filterStart: LiveData<Boolean> = _filterStart

    init {
        getPersonsFromStorage()
        getChips()
    }

    fun filterStartUpdate(status: Boolean) {
        _filterStart.value = status
    }

    fun updateCurrentChips(profession: Profession, status: Boolean) {
        val list = _filterChips.value

        if (status) list?.add(profession)
        else list?.remove(profession)

        _filterChips.value = list
    }

    fun filterData(professionalsBack: MutableList<Profession>): MutableList<PersonItem>? {

        val list: MutableList<PersonItem>? = _listPersons.value

        val newList: List<PersonItem>? = list?.filter { personItem ->
            personItem.professions!!.any { profession -> professionalsBack.contains(profession) }
        }

        return newList as MutableList<PersonItem>
    }

    private fun getChips() {
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

    private fun getPersonsFromStorage() {
        _listPersons.value = repository.getPersons() as MutableList<PersonItem>
    }
}