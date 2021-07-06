package com.example.calculodenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calcular.setOnClickListener {

            val nota1 = Integer.parseInt(binding.nota1.text.toString())
            val nota2 = Integer.parseInt(binding.nota2.text.toString())
            val media: Double = (nota1 + nota2) / 2.0
            val faltas = Integer.parseInt(binding.faltas.text.toString())

            if (media >= 6 && faltas <= 10) {
                binding.resultado.text = "Aluno foi aprovado!\n" +
                        "Média: $media\n" +
                        "Faltas: $faltas\n"
                binding.resultado.setTextColor(Color.GREEN)
            } else {
                binding.resultado.text = "Aluno foi reprovado!\n" +
                        "Média: $media\n" +
                        "Faltas: $faltas\n"
                binding.resultado.setTextColor(Color.RED)
            }
        }
    }
}