package com.secondworld.globaltestproject.data.animals.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseAnimal(

	@field:SerializedName("weight_min")
	val weightMin: String? = null,

	@field:SerializedName("habitat")
	val habitat: String? = null,

	@field:SerializedName("image_link")
	val imageLink: String? = null,

	@field:SerializedName("latin_name")
	val latinName: String? = null,

	@field:SerializedName("lifespan")
	val lifespan: String? = null,

	@field:SerializedName("geo_range")
	val geoRange: String? = null,

	@field:SerializedName("length_min")
	val lengthMin: String? = null,

	@field:SerializedName("active_time")
	val activeTime: String? = null,

	@field:SerializedName("weight_max")
	val weightMax: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("diet")
	val diet: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("animal_type")
	val animalType: String? = null,

	@field:SerializedName("length_max")
	val lengthMax: String? = null
)