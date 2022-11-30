package com.secondworld.globaltestproject.ui.model

import com.secondworld.globaltestproject.data.Profession

data class PersonItem(
    val id : Int,
    val name : String? = null,
    val age : Int? = null,
    val professions : List<Profession>? = null,
    val descr : String? = null,
    val active : Boolean = true
)