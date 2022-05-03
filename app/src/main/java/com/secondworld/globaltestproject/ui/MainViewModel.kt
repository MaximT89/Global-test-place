package com.secondworld.globaltestproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.data.ApiResult
import com.secondworld.globaltestproject.domain.BaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val baseInteractor: BaseInteractor.Base
) : ViewModel() {

    private var _data = MutableStateFlow<ApiResult>(ApiResult.Empty)
    val data : StateFlow<ApiResult> = _data

    fun fetchData() {
        viewModelScope.launch(Dispatchers.Main) {
            _data.value = baseInteractor.get()
        }
    }
}