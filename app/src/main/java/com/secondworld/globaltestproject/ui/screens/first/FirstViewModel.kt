package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.data.OfferModel
import com.secondworld.globaltestproject.data.StorageData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val storage: StorageData) : BaseViewModel() {

    private val _mainData = MutableLiveData<List<OfferModel>>(listOf())
    val mainData: LiveData<List<OfferModel>> = _mainData

    init {
        getData()
    }

    private fun getData() {
        _mainData.value = correctDataTitle(storage.getMainData())
    }

    private fun correctDataTitle(data: List<OfferModel>): List<OfferModel> {
        var tempData = ""
        val newList: MutableList<OfferModel> = mutableListOf()
        for (item in data) {
            if (item.date != tempData) {
                newList.add(item.copy(firstInDay = true))
                tempData = item.date
            } else newList.add(item.copy())
        }
        return newList.toList()
    }

    @SuppressLint("NewApi")
    fun deleteItem(id: Int) {
        val list = _mainData.value?.toMutableList()!!
        list.removeIf { it.id == id }

        _mainData.value = correctDataTitle(list)
    }

}
