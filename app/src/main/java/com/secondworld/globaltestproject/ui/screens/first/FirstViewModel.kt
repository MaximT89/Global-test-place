package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.bases.BaseResult
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.bases.Dispatchers
import com.secondworld.globaltestproject.data.remote.model.ResponsePost
import com.secondworld.globaltestproject.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repository: PostRepository,
    private val dispatchers: Dispatchers
) : BaseViewModel() {

    private val _postScreenState = MutableLiveData<PostScreenState>()
    val postScreenState : LiveData<PostScreenState> = _postScreenState

    init {
        getPost()
    }

    fun getPost() {

        _postScreenState.value = PostScreenState.Loading
        dispatchers.launchBackground(viewModelScope){

            val result = repository.getPost()

            when(result){
                is BaseResult.Error -> _postScreenState.postValue(PostScreenState.Error("Error"))
                is BaseResult.Success -> _postScreenState.postValue(PostScreenState.Success(result.data))
            }
        }
    }
}

sealed class PostScreenState {

    object Loading : PostScreenState()
    class Success(val data : ResponsePost) : PostScreenState()
    class Error(val errorMessage : String) : PostScreenState()

}