package com.secondworld.globaltestproject.data
import javax.inject.Inject

class Repository @Inject constructor(private val preferences: SharedPreferences){

    fun saveScore(score : Int) { preferences.saveScore(score) }
    fun getScore() = preferences.getScore()
}