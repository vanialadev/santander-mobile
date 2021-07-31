package com.vaniala.navegacaoaparenciaestilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updateList()
    }

    private fun bindViews() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(arrayListOf(
            Contact(
                name = "vania",
                phone = "(85) 98888-8888",
                photograph = "img.png"
            ),
            Contact(
                name = "erica",
                phone = "(85) 98888-8888",
                photograph = "img.png"
            )
        ))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

    }

}