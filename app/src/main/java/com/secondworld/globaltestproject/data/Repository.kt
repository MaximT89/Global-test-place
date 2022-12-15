package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.data.storage.BigModelStorage
import com.secondworld.globaltestproject.data.storage.LeftMenuStorage
import javax.inject.Inject

class Repository @Inject constructor(
    private val leftMenuStorage: LeftMenuStorage,
    private val bigModelStorage: BigModelStorage,
) {

    fun generateLeftMenuItems() = leftMenuStorage.createSomeItemsForLeftMenu()

    fun getBigModel() = bigModelStorage.getBigModel()
}