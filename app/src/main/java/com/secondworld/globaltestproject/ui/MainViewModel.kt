package com.secondworld.globaltestproject.ui

import androidx.lifecycle.*
import com.secondworld.globaltestproject.domain.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    private var _savedName = MutableLiveData<String>()
    val savedName : LiveData<String> = _savedName

    fun formatName(name : String) {
        _savedName.value = mainUseCase.formatName(name)
    }

}