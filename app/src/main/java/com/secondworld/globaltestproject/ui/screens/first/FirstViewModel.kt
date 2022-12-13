package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.data.room.AppDao
import com.secondworld.globaltestproject.data.room.EntityWord
import com.secondworld.globaltestproject.data.room.WordsWithTags
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val dao: AppDao) : BaseViewModel() {

    private val _listEntityWordWithTags = MutableLiveData<List<WordsWithTags>>(listOf())
    val listWordsWithTags : LiveData<List<WordsWithTags>> = _listEntityWordWithTags

    fun saveWord(enWord: String, ruWord: String) {
        viewModelScope.launch {

            val newWord = EntityWord(
                wordId = 0,
                enWord = enWord,
                ruWord = ruWord
            )

            insertWord(newWord)

            _listEntityWordWithTags.postValue(dao.getWordsWithTags())
        }
    }

    private suspend fun insertWord(newWord : EntityWord) = withContext(Dispatchers.Default) {
        val wordWithTag = WordsWithTags(word = newWord, tags = null)
        dao.insert(wordWithTag)
    }



}