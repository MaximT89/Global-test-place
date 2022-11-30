package com.secondworld.globaltestproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.secondworld.globaltestproject.databinding.ActivityAlertBinding

class AlertActivity : AppCompatActivity() {

    private val binding : ActivityAlertBinding by lazy {
        ActivityAlertBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val extras = intent.extras
        val newText: String?

        if (extras != null) {
            newText = extras.getString("text_notification")
            binding.textAlert.text = newText
        }
    }
}