package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.core.bases.Match

data class OfferModel(
    val id : Int,
    val date : String,
    val image : Int,
    val price : String,
    val name : String,
    var firstInDay : Boolean = false
) : Match<OfferModel> {
    override fun matches(model: OfferModel): Boolean = model == this

    override fun matchesId(model: OfferModel): Boolean  = model.id == id

}