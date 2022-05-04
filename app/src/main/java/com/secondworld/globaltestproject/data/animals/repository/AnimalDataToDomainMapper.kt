package com.secondworld.globaltestproject.data.animals.repository

import com.secondworld.globaltestproject.core.Mapper
import com.secondworld.globaltestproject.data.animals.remote.dto.ResponseAnimal
import com.secondworld.globaltestproject.domain.animal.model.AnimalModel
import javax.inject.Inject

class AnimalDataToDomainMapper @Inject constructor() : Mapper<ResponseAnimal, AnimalModel> {

    override fun map(data: ResponseAnimal): AnimalModel {
        return AnimalModel(
            data.weightMin,
            data.habitat,
            data.imageLink,
            data.latinName,
            data.lifespan,
            data.geoRange,
            data.lengthMin,
            data.activeTime,
            data.weightMax,
            data.name,
            data.diet,
            data.id,
            data.animalType,
            data.lengthMax
        )
    }
}