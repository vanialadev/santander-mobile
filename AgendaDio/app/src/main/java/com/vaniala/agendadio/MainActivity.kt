package com.vaniala.agendadio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSrtEvent = findViewById<Button>(R.id.set_event)

        btnSrtEvent.setOnClickListener {

            val intent =  Intent(Intent.ACTION_INSERT)
                .setData(CONTENT_URI)
                .putExtra(TITLE, "bootcamp santander")
                .putExtra(EVENT_LOCATION, "on line")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 60 * 60 * 1000 + System.currentTimeMillis())

            startActivity(intent)
        }
    }
}