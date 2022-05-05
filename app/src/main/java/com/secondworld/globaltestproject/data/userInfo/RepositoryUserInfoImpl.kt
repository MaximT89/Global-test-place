package com.secondworld.globaltestproject.data.userInfo

import com.secondworld.globaltestproject.data.api.remote.ApiService
import com.secondworld.globaltestproject.domain.userInfo.RepositoryUserInfo
import javax.inject.Inject

class RepositoryUserInfoImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: UserDataToDomainMapper,
) : RepositoryUserInfo {

    override fun fetchUserInfo() = mapper.map(apiService.provideResponseUser())

}