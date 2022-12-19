package com.secondworld.globaltestproject.data

data class OfferModel(
    val id : Int,
    val date : String,
    val image : Int,
    val price : String,
    val name : String,
    var firstInDay : Boolean = false
)