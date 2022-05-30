package com.secondworld.globaltestproject.core

import com.secondworld.globaltestproject.R

enum class Navigator(val destination: Int) {
    TO_SECOND(R.id.secondFragment),
    TO_THIRD(R.id.action_secondFragment_to_thirdFragment),
    TO_FOURTH(R.id.action_thirdFragment_to_fourthFragment)
}