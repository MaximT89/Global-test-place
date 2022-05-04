package com.secondworld.globaltestproject.ui.animals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.domain.animal.interactor.AnimalInteractor
import com.secondworld.globaltestproject.domain.animal.model.AnimalModel
import com.secondworld.globaltestproject.domain.common.BaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@HiltViewModel
class MainViewModel @Inject constructor(
    private val animalInteractor: AnimalInteractor
) : ViewModel() {

    private var _state = MutableStateFlow<MainActivityState>(MainActivityState.Init)
    val state: StateFlow<MainActivityState> = _state

    private fun setLoading() {
        _state.value = MainActivityState.IsLoading(true)
    }

    private fun hideLoading() {
        _state.value = MainActivityState.IsLoading(false)
    }

    init {
        animalInit()
    }

    private fun animalInit() {
        viewModelScope.launch {
            animalInteractor.get()
                .onStart { setLoading() }
                .catch { hideLoading() }
                .collect { baseResult ->
                    delay(3000)
                    hideLoading()
                    when (baseResult) {
                        is BaseResult.Error -> _state.value =
                            MainActivityState.Error(baseResult.errorMessage)
                        is BaseResult.Success<*> -> {
                            _state.value =
                                MainActivityState.Success(baseResult.data as List<AnimalModel>)
                        }
                    }
                }
        }
    }
}

sealed class MainActivityState {
    object Init : MainActivityState()
    data class IsLoading(val isLoading: Boolean) : MainActivityState()
    data class Success(val data: List<AnimalModel>) : MainActivityState()
    data class Error(val error: String) : MainActivityState()
}