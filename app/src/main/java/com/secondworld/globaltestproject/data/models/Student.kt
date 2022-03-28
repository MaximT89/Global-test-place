package com.secondworld.globaltestproject.data.models

import com.secondworld.globaltestproject.ui.RecyclerViewItem

data class Student(
    val name: String,
    val age: Int,
    val course : Int
) : RecyclerViewItem
