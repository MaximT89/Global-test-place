package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.core.upItem
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.repository.Repository
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val personAdapter = PersonAdapter()
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
        initObservers()
    }

    private fun initObservers() {
        viewModel.listPerson.observe(this) {
            if (it != null) {
                personAdapter.submitList(it.toMutableList())
            }
        }
    }

    private fun initData() {

        viewModel.getPerson()

        personAdapter.callBackPerson = { position, _ ->
            viewModel.removePerson(position)
        }

        personAdapter.callBackArrowUp = {
            viewModel.upElement(it)
        }

        personAdapter.callBackArrowDown = {
            viewModel.downElement(it)
        }
    }

    private fun initView() {

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = personAdapter
        }
    }
}

