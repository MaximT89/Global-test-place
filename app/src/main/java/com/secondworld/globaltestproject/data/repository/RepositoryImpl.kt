package com.secondworld.globaltestproject.data.repository

import com.secondworld.globaltestproject.data.model.BigUserModel
import com.secondworld.globaltestproject.data.model.UserActionDataToDomainMapper
import com.secondworld.globaltestproject.data.model.UserInfoDataToDomainMapper
import com.secondworld.globaltestproject.data.model.UserOffersDataToDomain
import com.secondworld.globaltestproject.data.storage.StorageData
import com.secondworld.globaltestproject.domain.model.UserAction
import com.secondworld.globaltestproject.domain.model.UserInfo
import com.secondworld.globaltestproject.domain.model.UserOffers
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    storageData: StorageData,
    private val userInfoDataToDomainMapper: UserInfoDataToDomainMapper,
    private val userActionDataToDomainMapper: UserActionDataToDomainMapper,
    private val userOffersDataToDomain: UserOffersDataToDomain
) : Repository {

    private val bigUserModel = BigUserModel(
        storageData.name(),
        storageData.age(),
        storageData.actions(),
        storageData.offers(),
        storageData.bonuses()
    )

    override fun fetchUserActions(): UserAction = userActionDataToDomainMapper.map(bigUserModel)

    override fun fetchUserData(): UserInfo = userInfoDataToDomainMapper.map(bigUserModel)

    override fun fetchUserOffers(): UserOffers = userOffersDataToDomain.map(bigUserModel)
}