package com.secondworld.globaltestproject.data.userBonuses

import com.secondworld.globaltestproject.data.api.remote.ApiService
import com.secondworld.globaltestproject.domain.userBonuses.RepositoryUserBonuses
import com.secondworld.globaltestproject.domain.userBonuses.UserBonuses
import javax.inject.Inject

class RepositoryUserBonusesImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: UserBonusesDataToDomainMapper
) : RepositoryUserBonuses {

    override fun fetchUserBonuses(): UserBonuses = mapper.map(apiService.provideResponseUser())
}