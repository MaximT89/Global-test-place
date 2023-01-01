package com.secondworld.globaltestproject.data.model

import com.google.gson.annotations.SerializedName

data class ResponseDogImage(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
