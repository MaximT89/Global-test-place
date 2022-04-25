package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.core.Refresh
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.domain.model.UserAction
import com.secondworld.globaltestproject.domain.model.UserInfo
import com.secondworld.globaltestproject.domain.model.UserOffers
import com.secondworld.globaltestproject.domain.useCases.UserActionsUseCase
import com.secondworld.globaltestproject.domain.useCases.UserDataUseCase
import com.secondworld.globaltestproject.domain.useCases.UserOffersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userActionsUseCase: UserActionsUseCase,
    private val userDataUseCase: UserDataUseCase,
    private val userOffersUseCase: UserOffersUseCase,
    private val repository: RepositoryImpl,
) : ViewModel(), Refresh {

    private var _userInfo = MutableLiveData<UserInfo>()
    val userInfo: LiveData<UserInfo> get() = _userInfo

    private var _userOffers = MutableLiveData<UserOffers>()
    val userOffers: LiveData<UserOffers> get() = _userOffers

    private var _userActions = MutableLiveData<UserAction>()
    val userActions: LiveData<UserAction> get() = _userActions


    init {
        getData()
    }

    override fun refreshData() {
        getData()
    }

    private fun getData() {
        _userInfo.value = userDataUseCase.get(repository)
        _userActions.value = userActionsUseCase.get(repository)
        _userOffers.value = userOffersUseCase.get(repository)
    }
}