package com.secondworld.globaltestproject.core.constants

object Constants {

    /**
     * Базовый URL для запросов на сервер ( используется в клиенте @MainRetrofitClient)
     */
    const val BASE_URL = "https://dev.ah-info.ru:8443/"

    /**
     * Урл сформированный каждым объектом в MainFragment ( используется в клиенте @ConnRetrofitClient)
     *
     * protocol :// ip : port / action - данные берем из модели [ResponseMainScreen]
     */

    const val ADMIN_PIN = "11998899"
}