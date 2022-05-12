package com.secondworld.globaltestproject.domain.userInfo

import javax.inject.Inject

class UserInfoInteractor @Inject constructor(private val repositoryUserInfo: RepositoryUserInfo) {

    fun execute() : UserInfo {
        return repositoryUserInfo.fetchUserInfo()
    }
}