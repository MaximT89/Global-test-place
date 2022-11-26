package com.secondworld.globaltestproject.ui

import androidx.lifecycle.*
import com.secondworld.globaltestproject.domain.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    private var _newData = MutableLiveData<List<String>?>()
    val newData : LiveData<List<String>?> = _newData


    private fun getList(list: List<Int>) {
        val newList = mutableListOf<String>()

        list.forEach {
            viewModelScope.launch {
                newList.add(it.toString())
            }
        }

        _newData.value = newList
    }
}