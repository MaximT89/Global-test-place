package com.secondworld.globaltestproject.ui

import android.R.attr
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.core.bases.BaseActivity
import com.secondworld.globaltestproject.core.common.click
import com.secondworld.globaltestproject.core.common.hide
import com.secondworld.globaltestproject.core.common.show
import com.secondworld.globaltestproject.data.remote.ResponseImageLoad
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val REQUEST_TAKE_PHOTO = 1
    private val SELECT_PICTURE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()

    }

    private fun initView() {
        binding.btnReload.click {
            viewModel.getImageFromServer()
        }

        binding.btnGetImage.click {



        }


        binding.btnSaveImg.click {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    fun getImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(
                intent,
                "Select Picture"
            ), SELECT_PICTURE
        )
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
//            // Фотка сделана, извлекаем миниатюру картинки
//            val thumbnailBitmap = data?.extras?.get("data") as Bitmap
//            binding.imageMain.setImageBitmap(thumbnailBitmap)
//        }
//        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) { }

        // Другой вариант с применением when
        when(requestCode){
            REQUEST_TAKE_PHOTO ->{
                if(resultCode == Activity.RESULT_OK && data !== null){
                    binding.imageMain.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            SELECT_PICTURE -> {
                val selectedImageUri: Uri? = data?.data
                Glide.with(this).load(selectedImageUri).into(binding.imageMain)
            }
            else ->{
                showSnackbar("Wrong request code")
            }
        }
    }

    private fun showSnackbar(message : String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    private fun initObservers() {

        viewModel.dataFromServer.observe(this) { state ->

            when (state) {
                is MainScreenState.Error -> showUi()
                MainScreenState.Loading -> showUi(progress = true)
                is MainScreenState.Success -> showUi(content = true, data = state.response)
            }
        }
    }

    private fun showUi(
        progress: Boolean = false,
        content: Boolean = false,
        data: ResponseImageLoad? = null
    ) {
        if (progress) binding.progressBar.show()
        else binding.progressBar.hide()

        if (content) binding.imageMain.show()
        else binding.imageMain.hide()

        if (data != null) {
            Glide.with(this).load(data.message).into(binding.imageMain)
        }
    }
}

