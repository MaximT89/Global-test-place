package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase

class MainViewModel(private val personUseCase: PersonUseCase) : ViewModel() {

    private var _listData = MutableLiveData<MutableList<RecyclerViewItem>>()
    val listData : LiveData<MutableList<RecyclerViewItem>> = _listData

    fun getPerson() {
        _listData.value = personUseCase.getListPerson()
    }

}