package com.secondworld.globaltestproject.data.model

data class BigUserModel(
    val name : String,
    val age : Int,
    val actions : MutableList<String>,
    val offers : MutableList<String>,
    val bonuses : Int
)