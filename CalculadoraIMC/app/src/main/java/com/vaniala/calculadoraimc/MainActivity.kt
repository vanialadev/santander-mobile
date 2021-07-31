package com.vaniala.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG = "lifecycle"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w(TAG, "onCreate: -estou crindo a tela", )
    }

    override fun onStart() {
        super.onStart()
        Log.w(TAG, "entrei no onStart -  deixei a tela visivel pra vc", )
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG, "entrei no onStart - agora vc pode interagir com  tela", )

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG, "onPause: a tela perdeu o fcco voce nao pode interagir", )
    }

    override fun onStop() {
        super.onStop()
        Log.w(TAG, "onStop: a tela nao etsa visivel, mas ainda existe", )
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.w(TAG, "onDestroy: oh no! a tela foi destruida", )
    }

    override fun onRestart() {
        super.onRestart()
        Log.w(TAG, "onRestart: a tela esta retornando o foco", )
    }
}