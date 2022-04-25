package com.secondworld.globaltestproject.data.model

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.domain.model.UserOffers
import javax.inject.Inject

class UserOffersDataToDomain @Inject constructor() : Mapper<BigUserModel, UserOffers> {
    override fun map(data: BigUserModel): UserOffers =
        data.let { (_, _, _, offers, _) -> UserOffers(offers) }
}