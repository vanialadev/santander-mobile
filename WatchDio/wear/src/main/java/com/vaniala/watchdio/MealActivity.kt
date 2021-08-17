package com.vaniala.watchdio

import android.app.Activity
import android.os.Bundle
import com.vaniala.watchdio.databinding.ActivityMealBinding

class MealActivity : Activity() {

    private lateinit var binding: ActivityMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}