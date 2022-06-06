package com.secondworld.globaltestproject.ui.screens.listNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.data.repository.NoteRepository
import com.secondworld.globaltestproject.domain.models.NoteDomain
import com.secondworld.globaltestproject.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private var _listNote: MutableLiveData<List<NoteDomain>?> = MutableLiveData()
    val listNote: LiveData<List<NoteDomain>?> = _listNote

    init {
        fetchNotes()
    }

    fun createNote() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNote()
            fetchNotes()
        }
    }

    private fun fetchNotes(){
        viewModelScope.launch(Dispatchers.IO){
            val notes = repository.getNotes()
            _listNote.postValue(notes)
        }
    }
}