package com.secondworld.globaltestproject.ui.screens.detailNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.data.repository.NoteRepository
import com.secondworld.globaltestproject.domain.models.NoteDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    private var _note : MutableLiveData<NoteDomain?> = MutableLiveData()
    val note : LiveData<NoteDomain?> = _note

    fun getNote(id : Int) {
        viewModelScope.launch(Dispatchers.IO){
            val noteTemp = noteRepository.getNoteById(id)
            _note.postValue(noteTemp)
        }
    }
}