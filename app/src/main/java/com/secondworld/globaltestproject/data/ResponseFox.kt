package com.secondworld.globaltestproject.data

import com.google.gson.annotations.SerializedName

data class ResponseFox (

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("link")
	val link: String? = null
)
