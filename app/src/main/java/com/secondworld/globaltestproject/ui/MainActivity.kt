package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val car = Car.Builder()
            .model("Fera")
            .year(2022)
            .build()

        val animal = Animal.Builder()
            .name("Cat")
            .build()

        Log.d("TAG", "onCreate: $animal")

    }
}

data class Animal(
    val name: String? = "",
    val age: Int? = 0
) {
    private constructor(builder: Builder) : this(builder.name, builder.age)

    class Builder {
        var name: String? = null
            private set

        var age: Int? = 0
            private set

        fun name(name : String) = apply { this.name = name }

        fun age(age : Int) = apply { this.age = age }

        fun build() = Animal(this)
    }
}

class Car(
    val model: String? = null,
    val year: Int = 0
) {
    private constructor(builder: Builder) : this(builder.model, builder.year)

    class Builder {
        var model: String? = null
            private set

        var year: Int = 0
            private set

        fun model(model: String) = apply { this.model = model }

        fun year(year: Int) = apply { this.year = year }

        fun build() = Car(this)
    }
}