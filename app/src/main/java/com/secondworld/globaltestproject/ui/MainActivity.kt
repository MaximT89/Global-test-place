package com.secondworld.globaltestproject.ui

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.MediaStore.Images
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.core.bases.BaseActivity
import com.secondworld.globaltestproject.core.common.click
import com.secondworld.globaltestproject.core.common.hide
import com.secondworld.globaltestproject.core.common.log
import com.secondworld.globaltestproject.core.common.show
import com.secondworld.globaltestproject.data.remote.ResponseImageLoad
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val REQUEST_TAKE_PHOTO = 1
    private val SELECT_PICTURE = 2

    private val TAKE_PICTURE_REQUEST = 3
    private var outputFileUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()

        val current = resources.configuration.locale
        log("current.country == ${current.country}")


    }

    private fun initView() {

        binding.btnReload.click {
            viewModel.getImageFromServer()
        }

        binding.btnGetImage.click {
            getImage()
        }

        binding.btnCamera.click {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            try {
                val file = File(
                    getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    "IMG_${System.currentTimeMillis()}.jpg"
                )
                outputFileUri = FileProvider.getUriForFile(
                    this,
                    "com.secondworld.globaltestproject.provider", file
                )
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
                startActivityForResult(intent, TAKE_PICTURE_REQUEST)

            } catch (e : Exception){
                log("error on start")
                e.printStackTrace()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun saveInGalleryQ(bitmap: Bitmap) {

        val filename = "IMG_${System.currentTimeMillis()}.jpg"
        var fos: OutputStream?
        var imageUri: Uri?
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            put(MediaStore.Video.Media.IS_PENDING, 1)
        }

        contentResolver.also { resolver ->
            imageUri = resolver.insert(Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            fos = imageUri?.let { resolver.openOutputStream(it) }
        }

        fos?.use { bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it) }

        contentValues.clear()
        contentValues.put(MediaStore.Video.Media.IS_PENDING, 0)
        contentResolver.update(imageUri!!, contentValues, null, null)
    }

    private fun getImage() {
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

        when (requestCode) {
            TAKE_PICTURE_REQUEST -> {
                if (resultCode == Activity.RESULT_OK) {

                    binding.imageMain.setImageURI(outputFileUri)

                } else showSnackbar("Wrong request code")
            }
            SELECT_PICTURE ->{
                Glide.with(this)
                    .load(data?.data)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(binding.imageMain)
            }
            else -> showSnackbar("Wrong request code")
        }
    }

    private fun savePhoto(bitmap: Bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) saveInGalleryQ(bitmap)
        else saveTheImageLegacyStyle(bitmap)
    }

    private fun saveTheImageLegacyStyle(bitmap: Bitmap) {

        val filename = "IMG_${System.currentTimeMillis()}.jpg"
        val imagesDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val image = File(imagesDir, filename)
        val fos: OutputStream = FileOutputStream(image)
        fos.use { bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it) }
    }


    private fun showSnackbar(message: String) {
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

            CoroutineScope(Dispatchers.IO).launch {
                val bitmap: Bitmap =
                    Glide.with(this@MainActivity).asBitmap().load(data.message).submit().get()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) saveInGalleryQ(bitmap)
                else saveTheImageLegacyStyle(bitmap)
            }

        }
    }
}

