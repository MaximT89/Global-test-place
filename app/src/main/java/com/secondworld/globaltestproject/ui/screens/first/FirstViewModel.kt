package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor() : BaseViewModel() {

    private val _startValue = MutableLiveData(-20)
    val startValue : LiveData<Int> = _startValue

    private val _endValue = MutableLiveData(20)
    val endValue : LiveData<Int> = _endValue

    fun getStartValue() = _startValue.value

    fun getEndValue() = _endValue.value

    fun updateStartValue(operation : Operation){
        when(operation){
            Operation.PLUS -> {
                val temp = _startValue.value?.plus(1)
                if(temp!! < _endValue.value!!) _startValue.value = temp
            }
            Operation.MINUS -> _startValue.value = _startValue.value?.minus(1)
        }
    }

    fun updateEndValue(operation : Operation){
        when(operation){
            Operation.PLUS -> _endValue.value = _endValue.value?.plus(1)
            Operation.MINUS -> {
                val temp = _endValue.value?.minus(1)
                if(temp!! > _startValue.value!!) _endValue.value = temp
            }
        }
    }

    fun updateHint() = "от ${_startValue.value} до ${_endValue.value}"

}

enum class Operation{
    PLUS,
    MINUS
}