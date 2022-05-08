package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.secondworld.globaltestproject.data.user.cache.room.AppDataBase
import com.secondworld.globaltestproject.data.user.cache.room.UserEntity
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.user.UserInteractor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.internal.ThreadSafeHeapNode

class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val userInteractor = UserInteractor()
    private val viewModel: MainViewModel by viewModels{
        ViewModelFactory(userInteractor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initObservers()
        initViews()
    }

    private fun initViews() {
        binding.btnAddUser.setOnClickListener {
            viewModel.insertUser(UserEntity(0, getName(), getAge()))
        }

        binding.btnGetAllUsers.setOnClickListener {
            viewModel.getUsers()
        }

        binding.btnDropTable.setOnClickListener {
            viewModel.cleanUsers()
        }
    }

    private fun getName(): String {
        return listOf("Max",
            "Nick",
            "Ann",
            "Peter").random()
    }

    private fun getAge() = (0..60).random()

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.users.collect { list ->
                updateUi(list)
            }
        }
    }

    private fun updateUi(list: List<UserEntity>) {
        val names = StringBuilder().apply {
            list.forEach { append(it.name).append("\n") }
        }.toString()

        binding.textName.text = names
    }
}

