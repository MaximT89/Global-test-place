package com.secondworld.globaltestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customer = Customer(CarBookingStrategy())
        var fare = customer.calculateFare(5)
        println(fare)

        customer.bookingStrategy = TrainBookingStrategy()
        fare = customer.calculateFare(5)
        println(fare)

    }
}

interface BookingStrategy {
    val fare: Double
}

class CarBookingStrategy : BookingStrategy {
    override val fare: Double = 12.5

    override fun toString(): String {
        return "CarBookingStrategy"
    }
}

class TrainBookingStrategy : BookingStrategy {
    override val fare = 8.5

    override fun toString(): String {
        return "TrainBookingStrategy"
    }
}

class Customer(var bookingStrategy: BookingStrategy) {

    fun calculateFare(numOfPassangeres: Int): Double {
        val fare = numOfPassangeres * bookingStrategy.fare
        println("Calculating $bookingStrategy")
        return fare
    }
}


