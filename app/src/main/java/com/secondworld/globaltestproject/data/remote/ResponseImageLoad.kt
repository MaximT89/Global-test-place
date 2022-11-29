package com.secondworld.globaltestproject.data.remote

import com.google.gson.annotations.SerializedName

data class ResponseImageLoad(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
