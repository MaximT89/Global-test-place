package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.R
import javax.inject.Inject

class StorageData @Inject constructor() {

    fun getMainData() = listOf(
        OfferModel(generateRandomId(), "Воскресенье, 20", R.drawable.item_1, "3339 руб", "Travel"),
        OfferModel(
            generateRandomId(),
            "Воскресенье, 20",
            R.drawable.item_2,
            "2339 руб",
            "Supermarket"
        ),
        OfferModel(
            generateRandomId(),
            "Воскресенье, 20",
            R.drawable.item_4,
            "329 руб",
            "Supermarket"
        ),
        OfferModel(generateRandomId(), "Понедельник, 21", R.drawable.item_2, "5539 руб", "Closing"),
        OfferModel(generateRandomId(), "Понедельник, 21", R.drawable.item_4, "19 руб", "Closing"),
        OfferModel(generateRandomId(), "Понедельник, 21", R.drawable.item_5, "33239 руб", "Travel"),
        OfferModel(generateRandomId(), "Вторник, 22", R.drawable.item_4, "3559 руб", "Travel"),
        OfferModel(
            generateRandomId(),
            "Вторник, 22",
            R.drawable.item_2,
            "312319 руб",
            "Supermarket"
        ),
        OfferModel(generateRandomId(), "Вторник, 22", R.drawable.item_1, "55639 руб", "Closing"),
        OfferModel(generateRandomId(), "Среда, 23", R.drawable.item_3, "36739 руб", "Closing"),
        OfferModel(generateRandomId(), "Среда, 23", R.drawable.item_5, "239 руб", "Travel"),
        OfferModel(generateRandomId(), "Среда, 23", R.drawable.item_4, "3339 руб", "Supermarket"),
    )


    private fun generateRandomId() = (1..99999).random() * 31
}