package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var expandableAdapter: ExpandableAdapter? = null
    private var expList: ExpandableListView? = null
    private val parents = arrayOf("Action Movies", "Romantic Movies", "Comedy Movies")
    private var Action_Movies: ArrayList<String>? = null
    private var Romantic_Movies: ArrayList<String>? = null
    private var Comedy_Movies: ArrayList<String>? = null
    private var childList: ArrayList<ArrayList<String>>? = null

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        expList = findViewById(R.id.exp_list)

        setChildMovies()

        expandableAdapter = childList?.let { ExpandableAdapter(this, it, parents) }
        expList!!.setAdapter(expandableAdapter)

    }
    private fun setChildMovies() {

        Action_Movies = ArrayList()
        Romantic_Movies = ArrayList()
        Comedy_Movies = ArrayList()
        childList = ArrayList()

        Action_Movies!!.add("Dark Knight")
        Action_Movies!!.add("Transporter")
        Action_Movies!!.add("Iron Man")

        Romantic_Movies!!.add("Twilight")
        Romantic_Movies!!.add("Titanic")
        Romantic_Movies!!.add("The House Bunny")

        Comedy_Movies!!.add("We are the millers")
        Comedy_Movies!!.add("Hang over")
        Comedy_Movies!!.add("Last Night")

        childList!!.add(Action_Movies!!)
        childList!!.add(Romantic_Movies!!)
        childList!!.add(Comedy_Movies!!)
    }
}

