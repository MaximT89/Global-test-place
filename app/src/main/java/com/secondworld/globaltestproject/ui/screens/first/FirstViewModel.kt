package com.secondworld.globaltestproject.ui.screens.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.data.Repository
import com.secondworld.globaltestproject.ui.screens.first.model.left_rv.ItemLeftMenu
import com.secondworld.globaltestproject.ui.screens.first.model.main_rv.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {

    private val _leftMenuItems = MutableLiveData<List<ItemLeftMenu>>(listOf())
    val leftMenuItems : LiveData<List<ItemLeftMenu>> = _leftMenuItems

    private val _listMainContentItems = MutableLiveData<List<BaseContentModel>>(listOf())
    val listMainContentItems : LiveData<List<BaseContentModel>> = _listMainContentItems

    private val _bigModel = MutableLiveData<BigModel>()

    init {
        getBigModel()
        getLeftMenuItems()
    }

    private fun getLeftMenuItems() {
        _leftMenuItems.value = repository.generateLeftMenuItems()
    }

    private fun getBigModel() {
        _bigModel.value = repository.getBigModel()
    }

    fun fetchMainContentItems(activeId: Int?) {

        // TODO: СМОТРИМ ТУТ

        var bigData : Category? = null
        _bigModel.value?.listCategory?.forEach { data -> if (data.id == activeId) bigData = data }

        val mutableListBaseModel = mutableListOf<BaseContentModel>()

        bigData?.apply {
            bannerImg?.let { mutableListBaseModel.add(BannerModelHolder(bannerImg)) }
            button?.let { mutableListBaseModel.add(ButtonModelHolder(button.titleButton)) }
            mainContentItems?.let { list ->
                list.forEach { mainContentItems ->
                    mutableListBaseModel.add(TitleModelHolder(mainContentItems.title))
                    mainContentItems.listSmallItems?.forEach { smallItem ->
                        mutableListBaseModel.add(ItemSmallModelHolder(smallItem.image, smallItem.title))
                    }
                }
            }
        }

        _listMainContentItems.value = mutableListBaseModel
    }

    fun changeActiveLeftItem(activeId: Int) {
        _leftMenuItems.value = _leftMenuItems.value?.map {
            if(it.id == activeId) it.copy(isActive = true)
            else it.copy(isActive = false)
        }
    }
}