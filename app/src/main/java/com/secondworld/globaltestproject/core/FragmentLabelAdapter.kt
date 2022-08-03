package com.secondworld.globaltestproject.core

import com.secondworld.globaltestproject.R
import javax.inject.Inject

class FragmentLabelAdapter @Inject constructor() {

    fun getFragmentByLabel(label : String) : Int = when(label){
        "fragment_second" -> R.id.secondFragment
        "fragment_third" -> R.id.thirdFragment
        else -> R.id.secondFragment
    }
}