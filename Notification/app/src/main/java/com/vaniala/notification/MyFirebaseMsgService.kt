package com.vaniala.notification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMsgService : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        if (remoteMessage.notification != null) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
            Log.d(TAG, "Message data payload: ${remoteMessage.notification}")

            if (remoteMessage.notification != null) {
                this.showNotification(
                    "1234",
                    remoteMessage.notification?.title.toString(),
                    remoteMessage.notification?.body.toString()
                )
            } else {

            }
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            this.showNotification(
                "1234",
                remoteMessage.notification?.title.toString(),
                remoteMessage.notification?.body.toString()
            )
        }
    }

    companion object {

        private const val TAG = "MyFirebaseMsgService"
    }
}