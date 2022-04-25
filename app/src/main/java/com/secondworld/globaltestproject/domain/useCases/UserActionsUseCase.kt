package com.secondworld.globaltestproject.domain.useCases

import com.secondworld.globaltestproject.core.BaseUseCase
import com.secondworld.globaltestproject.domain.model.UserAction
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class UserActionsUseCase @Inject constructor() : BaseUseCase<UserAction, Repository> {
    override fun get(repository: Repository): UserAction = repository.fetchUserActions()
}