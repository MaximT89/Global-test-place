package com.secondworld.globaltestproject.domain.useCases

import com.secondworld.globaltestproject.core.BaseUseCase
import com.secondworld.globaltestproject.domain.model.UserInfo
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class UserDataUseCase @Inject constructor() : BaseUseCase<UserInfo, Repository> {
    override fun get(repository: Repository): UserInfo = repository.fetchUserData()
}