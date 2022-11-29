package com.secondworld.globaltestproject.ui

import androidx.lifecycle.*
import com.secondworld.globaltestproject.core.bases.BaseResult
import com.secondworld.globaltestproject.core.common.Dispatchers
import com.secondworld.globaltestproject.data.Repository
import com.secondworld.globaltestproject.data.remote.ResponseImageLoad
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchers: Dispatchers,
    private val repository: Repository
) : ViewModel() {

    private val _dataFromServer = MutableLiveData<MainScreenState>()
    val dataFromServer: LiveData<MainScreenState> = _dataFromServer

    private val _imageUrl = MutableLiveData<String?>()
    val imageUrl : LiveData<String?> = _imageUrl

    init {
        getImageFromServer()
    }

    fun getImage() : String? {
        return _imageUrl.value
    }

    fun getImageFromServer() {
        _dataFromServer.value = MainScreenState.Loading
        dispatchers.launchBackground(viewModelScope) {
            val result = repository.getImage()

            when (result) {
                is BaseResult.Error -> _dataFromServer.postValue(MainScreenState.Error("что-то пошло не так"))
                is BaseResult.Success -> {
                    _dataFromServer.postValue(MainScreenState.Success(result.data))
                    _imageUrl.postValue(result.data.message)
                }
            }
        }
    }
}

sealed class MainScreenState {
    object Loading : MainScreenState()
    class Error(val errorMessage: String) : MainScreenState()
    class Success(val response: ResponseImageLoad) : MainScreenState()
}