package com.secondworld.globaltestproject.data.api.remote

import com.secondworld.globaltestproject.data.api.dto.ResponseUser
import javax.inject.Inject

class ApiService @Inject constructor() {

    fun provideResponseUser() = ResponseUser("Max", 1000)
}