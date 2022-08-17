package com.secondworld.globaltestproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.secondworld.globaltestproject.core.hide
import com.secondworld.globaltestproject.core.show
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

    private fun initObservers() = with(viewModel) {
        listPerson.observe(this@MainActivity) {
            personAdapter.submitList(it)
        }

        usersState.observe(this@MainActivity) {
            when (it) {
                UserState.CheckUsers -> {
                    binding.btns.show()
                    binding.title.hide()
                }
                UserState.NormalState -> {
                    binding.btns.hide()
                    binding.title.show()
                }
            }
        }
    }

    private fun initView() = with(binding) {

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = personAdapter
        }

        btnCancel.setOnClickListener {
            viewModel.cancelActiveUser()
            viewModel.checkUser(false)
        }

        btnDelete.setOnClickListener {
            viewModel.checkUser(false)
            viewModel.deleteCheckedUsers()
        }

        personAdapter.callBackShortClick = { id ->
            if (viewModel.checkActive.value == true) viewModel.changeActivePerson(id)
            else startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }

        personAdapter.callBackLongClick = { id ->
            viewModel.checkUser(true)
            viewModel.changeActivePerson(id)
        }
    }
}