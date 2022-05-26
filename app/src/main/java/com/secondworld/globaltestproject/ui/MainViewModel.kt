package com.secondworld.globaltestproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.domain.models.Animals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RepositoryImpl) : ViewModel() {

    private var _animals: MutableStateFlow<List<Animals>> = MutableStateFlow(emptyList())
    val animals : StateFlow<List<Animals>> = _animals.asStateFlow()

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch(Dispatchers.IO) {
            _animals.emit(repository.generateAnimals())
        }
    }
}