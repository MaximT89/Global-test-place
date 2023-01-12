package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.data.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val api : Service) : BaseViewModel() {

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            api.getData()
        }
    }


}
