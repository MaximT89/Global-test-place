package com.secondworld.globaltestproject.data.model

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.domain.model.UserAction
import javax.inject.Inject

class UserActionDataToDomainMapper : Mapper<BigUserModel, UserAction> {
    override fun map(data: BigUserModel): UserAction =
        data.let { (_, _, actions, _, _) -> UserAction(actions[(0 until actions.size).random()]) }
}