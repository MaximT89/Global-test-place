package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
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

    private val itemTouchHelper by lazy {
        val itemTouchCallback =
            object : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val recyclerviewAdapter = recyclerView.adapter as PersonAdapter
                    val fromPosition = viewHolder.absoluteAdapterPosition
                    val toPosition = target.absoluteAdapterPosition
                    recyclerviewAdapter.moveItem(fromPosition, toPosition)
                    recyclerviewAdapter.notifyItemMoved(fromPosition, toPosition)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
            }
        ItemTouchHelper(itemTouchCallback)
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

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = personAdapter
        }
    }
}

