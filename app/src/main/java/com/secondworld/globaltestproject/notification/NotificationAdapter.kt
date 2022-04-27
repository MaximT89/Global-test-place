package com.secondworld.globaltestproject.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.secondworld.globaltestproject.R

interface NotificationAdapter {

    fun createNotificationChannel()
    fun createNotification(message : String)

    class Base(private val context : Context) : NotificationAdapter{

        override fun createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                if (notificationManager.getNotificationChannel("1") == null) {
                    val name = "Channel_1"
                    val descriptionText = "Some text"
                    val importance = NotificationManager.IMPORTANCE_HIGH
                    val mChannel = NotificationChannel("1", name, importance)
                    mChannel.description = descriptionText
                    notificationManager.createNotificationChannel(mChannel)
                }
            }
        }

        override fun createNotification(message: String) {
            createNotificationChannel()
            val builder = NotificationCompat.Builder(context, "1")
                .setSmallIcon(R.drawable.ic_add)
                .setContentTitle("Chat heads active")
                .setContentText("Notification $message")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(context)) {
                notify(1, builder.build())
            }
        }
    }
}