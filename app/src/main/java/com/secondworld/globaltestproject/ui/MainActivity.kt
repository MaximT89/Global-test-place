package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.data.models.Student
import com.secondworld.globaltestproject.data.repository.Repository
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @Inject lateinit var repository : Repository
    private val myAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initData() {
        myAdapter.items = repository.fetchPersons()

        myAdapter.callBackTest = { view, item, position ->
            when(item){
               is Student -> {
                   Snackbar.make(this, view, "${item.name} from course ${item.course}" , Snackbar.LENGTH_LONG).show()
               }
            }
        }
    }

    private fun initView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = myAdapter
        }
    }
}