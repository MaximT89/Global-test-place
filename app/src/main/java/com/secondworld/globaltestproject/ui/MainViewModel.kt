package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.domain.userBonuses.UserBonuses
import com.secondworld.globaltestproject.domain.userBonuses.UserBonusesInteractor
import com.secondworld.globaltestproject.domain.userInfo.UserInfo
import com.secondworld.globaltestproject.domain.userInfo.UserInfoInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userInfoInteractor: UserInfoInteractor,
    private val userBonusesInteractor: UserBonusesInteractor
) : ViewModel() {

    private var _data = MutableLiveData<UserInfo>()
    val data: LiveData<UserInfo> get() = _data

    private var _dataBonuses = MutableLiveData<UserBonuses>()
    val dataBonuses: LiveData<UserBonuses> get() = _dataBonuses

    init {
        getUser()
        getUserBonuses()
    }

    private fun getUser() {
        _data.value = userInfoInteractor.execute()
    }

    private fun getUserBonuses(){
        _dataBonuses.value = userBonusesInteractor.execute()
    }



}