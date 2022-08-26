package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.Px
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory.DIRECTION_RIGHT
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.repository.Repository
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository: Repository = RepositoryImpl()
    private val personAdapter = PersonAdapter()
    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory(PersonUseCase(repository))
    }

    companion object {
        @Px
        val SCROLL_X = 10
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
        initObservers()

        CoroutineScope(Dispatchers.Default).launch {
            delay(1000)
            autoScrollList()
        }
    }

    private tailrec suspend fun autoScrollList() {
        if (binding.recyclerView.canScrollHorizontally(DIRECTION_RIGHT)) {
            binding.recyclerView.smoothScrollBy(SCROLL_X, 0)
        } else {
            val firstPosition =
                (binding.recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
            if(firstPosition != RecyclerView.NO_POSITION){
                val currentList = personAdapter.currentList
                val firstPart = currentList.subList(firstPosition, currentList.size)
                val secondPart = currentList.subList(0, firstPosition)
                personAdapter.submitList(firstPart + secondPart)
            }
        }
        delay(100)
        autoScrollList()
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
    }

    private fun initView() {

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = personAdapter
        }
    }
}

