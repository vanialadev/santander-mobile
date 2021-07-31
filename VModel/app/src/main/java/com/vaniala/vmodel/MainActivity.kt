package com.vaniala.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var txtContador: TextView
    private lateinit var btnDados: Button
    private lateinit var btnMostrar: Button

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()
    }


    private fun initDados() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mainViewModel.mContador.observe(this, Observer {
            txtContador.text = it
        })
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            mainViewModel.Contador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(this, "Valor do contador é ${mainViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

}