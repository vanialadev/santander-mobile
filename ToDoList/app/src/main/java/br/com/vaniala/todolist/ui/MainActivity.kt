package br.com.vaniala.todolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.vaniala.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}