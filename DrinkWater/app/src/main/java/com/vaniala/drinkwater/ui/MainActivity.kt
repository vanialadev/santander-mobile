package com.vaniala.drinkwater.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import android.widget.TextView
import com.vaniala.drinkwater.R
import com.vaniala.drinkwater.sync.DrinkWaterReminderIntentService
import com.vaniala.drinkwater.sync.DrinkWaterReminderTask
import com.vaniala.drinkwater.utlis.PreferencesUtils

class MainActivity : AppCompatActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    lateinit var  quantity: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageview_cup_icon)
         quantity = findViewById(R.id.textview_quantity)

        updateWaterCount()

        image.setOnClickListener {
            incrementWaterHandler()
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    fun updateWaterCount() {
        val count = PreferencesUtils.getWaterCount(this)
        quantity.text = "$count"
    }

    fun incrementWaterHandler() {
        val intent = Intent(this, DrinkWaterReminderIntentService::class.java)
        intent.action = DrinkWaterReminderTask.ACTION_INCREMENT_WATER_COUNT
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (PreferencesUtils.KEY_WATER_COUNT == key) {
            updateWaterCount()
        }
    }
}