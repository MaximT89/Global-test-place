package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseResult
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.data.model.ResponseDogImage
import com.secondworld.globaltestproject.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {

    private val _mainUiState = MutableLiveData<MainUiState>()
    val mainUiState : LiveData<MainUiState> = _mainUiState

    init {
        getServerData()
    }

    fun getServerData() {
        viewModelScope.launch {
            when(val result = repository.getDogImage()) {
                is BaseResult.Error -> _mainUiState.postValue(MainUiState.Error(result.err.message))
                is BaseResult.Success -> _mainUiState.postValue(MainUiState.Success(result.data))
            }
        }
    }
}

sealed class MainUiState{
    class Success(val data : ResponseDogImage) : MainUiState()
    class Error(val errorMessage : String) : MainUiState()
}
