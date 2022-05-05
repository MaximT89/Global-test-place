package com.secondworld.globaltestproject.domain.userBonuses

import javax.inject.Inject

class UserBonusesInteractor @Inject constructor(private val repositoryUserBonuses: RepositoryUserBonuses) {

    fun execute() : UserBonuses = repositoryUserBonuses.fetchUserBonuses()
}