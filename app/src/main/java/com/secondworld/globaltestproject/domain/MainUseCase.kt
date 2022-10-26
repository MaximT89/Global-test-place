package com.secondworld.globaltestproject.domain

import javax.inject.Inject

class MainUseCase @Inject constructor() {

    fun formatName(name : String) = "name: $name"
}