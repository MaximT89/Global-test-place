package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.secondworld.globaltestproject.core.log
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.repository.Repository
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storageName = StorageName()
    private val repository: Repository = RepositoryImpl(storageName)
    private val personAdapter = PersonAdapter()
    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory(PersonUseCase(repository))
    }

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
                log("Сработало")
                personAdapter.items = it.map{ it.copy()}.toMutableList()
            }
        }
    }

    private fun initData() {

        viewModel.getPerson()

        personAdapter.callBackPerson = { position, _ ->
            viewModel.removePerson(position)
//            personAdapter.removePerson(position)
        }

    }

    private fun initView() {

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = personAdapter
        }
    }
}

