package com.secondworld.globaltestproject.domain.userBonuses

import com.secondworld.globaltestproject.domain.userInfo.UserInfo

interface RepositoryUserBonuses {

    fun fetchUserBonuses() : UserBonuses
}