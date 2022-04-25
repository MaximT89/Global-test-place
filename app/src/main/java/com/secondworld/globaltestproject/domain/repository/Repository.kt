package com.secondworld.globaltestproject.domain.repository

import com.secondworld.globaltestproject.domain.model.UserAction
import com.secondworld.globaltestproject.domain.model.UserInfo
import com.secondworld.globaltestproject.domain.model.UserOffers

interface Repository {

    fun fetchUserActions() : UserAction

    fun fetchUserData() : UserInfo

    fun fetchUserOffers() : UserOffers
}