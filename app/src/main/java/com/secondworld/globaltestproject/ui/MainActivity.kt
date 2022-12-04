package com.secondworld.globaltestproject.ui

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.BaseActivity
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    companion object{
        const val CHANNEL_ID = "channel_id_1"
        const val notificationId = 541
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        createNotificationChannel() // создание канала нотификации
    }


    fun createNotification() : Notification{

        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, AlertActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("text_notification", "text alert new") // можно передать в интент какие то данные
        }

        // FLAG_UPDATE_CURRENT - нужен для чтения из нотификации
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_hotel_24)
            .setContentTitle("Новое уведомление")
            .setContentText("Какой то текст этого уведомления")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).also {
                it.setContentIntent(pendingIntent)
            }
            .setAutoCancel(true)

        return builder.build()
    }


    private fun initView() {

        binding.btnTest.click {
            val intent = Intent(this, AlertActivity::class.java)
            intent.putExtra("text_notification", "text alert new")

            startActivity(intent)
        }

        binding.btnShowNotification.click {
            with(NotificationManagerCompat.from(this)) { notify(notificationId, createNotification()) }
        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, "Channel_1", importance).apply {
                description = "это описание канала"
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

