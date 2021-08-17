package com.vaniala.clienteprovider

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
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
        getContentProvider()

        noteRefreshButton.setOnClickListener {
            getContentProvider()
        }

    }

    private fun getContentProvider() {
        try {
            val url = "content://com.vania.notesprovider.provider/notes"
            val data = Uri.parse(url)
            val cursor: Cursor? =
                contentResolver.query(
                    data, null, null, null, "title"
                )
            noteRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}