package com.secondworld.globaltestproject.ui.screens.mainScreen

import com.secondworld.globaltestproject.core.Communication
import com.secondworld.globaltestproject.data.model.Animal
import com.secondworld.globaltestproject.data.model.User
import javax.inject.Inject

interface CommunicationUsers : Communication<List<User>> {
    class UiUpdateUser @Inject constructor() : Communication.UiUpdate<List<User>>(), CommunicationUsers
}