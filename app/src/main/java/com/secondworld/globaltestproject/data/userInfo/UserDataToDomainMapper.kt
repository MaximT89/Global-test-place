package com.secondworld.globaltestproject.data.userInfo

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.data.api.dto.ResponseUser
import com.secondworld.globaltestproject.domain.userInfo.UserInfo
import javax.inject.Inject

class UserDataToDomainMapper @Inject constructor() : Mapper<ResponseUser, UserInfo> {
    override fun map(data: ResponseUser): UserInfo {
        return UserInfo(data.name)
    }
}