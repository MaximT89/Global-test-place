package com.secondworld.globaltestproject.data.storage

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StorageData @Inject constructor() {

    fun name() = mutableListOf(
        "Max",
        "Tony",
        "Ann"
    ).random()

    fun age() = (15..70).random()

    fun bonuses() = (0..10000).random()

    fun actions() = mutableListOf(
        "Успей купить! Только до 32 июля скидки!",
        "Летнее предложение, все бриллианты со скидкой 50%"
    )

    fun offers() = mutableListOf(
        "Заказ №503546 Серьги : 35600 рублей",
        "Заказ №504472 Кольцо с фианитами : 13600 рублей",
        "Заказ №507547 Подвеска с рубином : 8700 рублей"
    )
}