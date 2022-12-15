package com.secondworld.globaltestproject.data.storage

import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.ui.screens.first.model.left_rv.ItemLeftMenu
import javax.inject.Inject

class LeftMenuStorage @Inject constructor() {

    fun createSomeItemsForLeftMenu() = listOf(
        ItemLeftMenu(1, R.drawable.img_left_1, "Новый год", true),
        ItemLeftMenu(2, R.drawable.img_left_2, "Подвески"),
        ItemLeftMenu(3, R.drawable.img_left_3, "Кольца"),
        ItemLeftMenu(4, R.drawable.img_left_4, "Black friday"),
        ItemLeftMenu(5, R.drawable.img_left_5, "Скидки"),
        ItemLeftMenu(6, R.drawable.img_left_6, "Серьги"),
        ItemLeftMenu(7, R.drawable.img_left_7, "Золото"),
        ItemLeftMenu(8, R.drawable.img_left_8, "Пирсинг"),
        ItemLeftMenu(9, R.drawable.img_left_1, "Обручалка"),
        ItemLeftMenu(10, R.drawable.img_left_2, "Цепи"),
        ItemLeftMenu(11, R.drawable.img_left_3, "Браслеты"),
        ItemLeftMenu(12, R.drawable.img_left_4, "Подвески"),
    )
}