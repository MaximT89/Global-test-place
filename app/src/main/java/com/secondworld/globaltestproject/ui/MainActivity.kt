package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.models.PersonsList
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.repository.Repository
import com.secondworld.globaltestproject.domain.useCases.PersonUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storageName = StorageName()
    private val repository: Repository = RepositoryImpl(storageName)
    private val personAdapter by lazy {
        PersonAdapter(this)
    }
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
        viewModel.listData.observe(this) {
            if (it != null) {
                val listString = listOf(
                    "Man",
                    "Son",
                    "bob"
                )
                val listes : MutableList<RecyclerViewItem> = mutableListOf()
                listes.add(PersonsList("Title", listString))
                listes.addAll(it)
                personAdapter.items = listes
            }
        }
    }

    private fun initData() {

        viewModel.getPerson()

    }

    private fun initView() {

        binding.recyclerView.adapter = personAdapter

        val callbackDragAndDrop = DragManageAdapter(
            adapter = personAdapter,
            dragDirs = ItemTouchHelper.UP.or(ItemTouchHelper.DOWN),
            swipeDirs = ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)
        )

        ItemTouchHelper(callbackDragAndDrop).apply {
            attachToRecyclerView(binding.recyclerView)
        }
    }
}

