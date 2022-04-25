package com.secondworld.globaltestproject.domain.useCases

import com.secondworld.globaltestproject.core.BaseUseCase
import com.secondworld.globaltestproject.domain.model.UserOffers
import com.secondworld.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class UserOffersUseCase @Inject constructor() : BaseUseCase<UserOffers, Repository> {
    override fun get(repository: Repository): UserOffers = repository.fetchUserOffers()
}