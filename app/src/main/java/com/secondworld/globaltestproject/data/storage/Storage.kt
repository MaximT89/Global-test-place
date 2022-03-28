package com.secondworld.globaltestproject.data.storage

import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.models.Student
import com.secondworld.globaltestproject.ui.RecyclerViewItem
import javax.inject.Inject

class Storage @Inject constructor(){

    fun fetchPersons() = arrayListOf<RecyclerViewItem>().apply {
        add(Person(arrayList.random(), (0..90).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Student(arrayList.random(), (0..90).random(), (1..5).random()))
        add(Person(arrayList.random(), (0..90).random()))
        add(Person(arrayList.random(), (0..90).random()))
    }


    private val arrayList = arrayOf("Max", "Sara", "Peter", "Mike", "John")



}