package com.secondworld.globaltestproject.ui.feature_one.screen_one

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.globaltestproject.core.extension.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FOneScreenOneViewModel @Inject constructor() : ViewModel() {

}