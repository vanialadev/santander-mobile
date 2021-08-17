package com.vaniala.clienteprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var noteRecycler: RecyclerView
    private lateinit var noteRefreshButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noteRecycler = findViewById(R.id.client_list)
        noteRefreshButton = findViewById(R.id.client_button_refresh)
        noteRefreshButton.setOnClickListener {
        }
    }
}