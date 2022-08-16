package com.secondworld.globaltestproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val personAdapter = PersonAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.listPerson.observe(this) {
            personAdapter.submitList(it)
        }
    }

    private fun initView() {

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = personAdapter
        }

        personAdapter.callBackShortClick = { id ->
//            viewModel.changeActivePerson(id)
//            Log.d("TAG", "callBackLongClick work")
//            startActivity(Intent(this, SecondActivity::class.java))
        }

        personAdapter.callBackLongClick = { id ->
            viewModel.changeActivePerson(id)
        }
    }
}

