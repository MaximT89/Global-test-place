package com.secondworld.globaltestproject.core

import com.secondworld.globaltestproject.R


enum class Destinations(val id : Int) {

    MAIN_TO_ARENA(R.id.action_mainMenuFragment3_to_arenaFragment),
    MAIN_TO_SHOP(R.id.action_mainMenuFragment3_to_shopFragment),

    SHOP_TO_MAIN(R.id.action_shopFragment_to_mainMenuFragment3),

    ARENA_TO_MAIN(R.id.action_arenaFragment_to_mainMenuFragment3)
}