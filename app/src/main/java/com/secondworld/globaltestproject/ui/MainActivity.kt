package com.secondworld.globaltestproject.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.updateText
import com.secondworld.globaltestproject.data.repository.RepositoryImpl
import com.secondworld.globaltestproject.data.storages.StorageName
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import com.secondworld.globaltestproject.domain.models.Animals
import com.secondworld.globaltestproject.domain.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storageName = StorageName()
    private val repository: Repository = RepositoryImpl(storageName)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.btnGenerateRandomAnimal.setOnClickListener {
            when (val animal = repository.generateAnimals().random()) {
                is Animals.Bird -> updateUi(animal)
                is Animals.Cat -> updateUi(animal)
                is Animals.Dog -> updateUi(animal)
            }
        }
    }

    private fun updateUi(animal: Animals) {
        when (animal) {
            is Animals.Bird -> {
                updateText(binding.textName, "Name: ${animal.name}")
                updateText(binding.textAge, "Age: ${animal.age}")
                updateImage(R.drawable.bird)
            }
            is Animals.Cat -> {
                updateText(binding.textName, "Name: ${animal.name}")
                updateText(binding.textAge, "Age: ${animal.age}")
                updateImage(R.drawable.cat)
            }
            is Animals.Dog -> {
                updateText(binding.textName, "Name: ${animal.name}")
                updateText(binding.textAge, "Age: ${animal.age}")
                updateImage(R.drawable.dog)
            }
        }
    }

    private fun updateImage(image: Int) {
        binding.imageAnimal.apply {
            setImageResource(image)
        }.also {
            animateImage(it)
        }
    }

    @SuppressLint("Recycle")
    private fun animateImage(image: ImageView) {
        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(image, View.SCALE_X, 1f, 1.2f, 1f),
                ObjectAnimator.ofFloat(image, View.SCALE_Y, 1f, 1.2f, 1f),
            )
            duration = 200
            start()
        }
    }
}

