package com.secondworld.globaltestproject.data.userBonuses

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.data.api.dto.ResponseUser
import com.secondworld.globaltestproject.domain.userBonuses.UserBonuses
import javax.inject.Inject

class UserBonusesDataToDomainMapper @Inject constructor() : Mapper<ResponseUser, UserBonuses> {
    override fun map(data: ResponseUser): UserBonuses {
        return UserBonuses(data.bonusValue)
    }
}