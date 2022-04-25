package com.secondworld.globaltestproject.data.model

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.domain.model.UserInfo
import javax.inject.Inject

class UserInfoDataToDomainMapper @Inject constructor() : Mapper<BigUserModel, UserInfo> {
    override fun map(data: BigUserModel): UserInfo = UserInfo(data.name, data.age, data.bonuses)
}
