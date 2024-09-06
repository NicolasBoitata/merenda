package com.example.gestormerenda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        // Usando findViewById para obter a referência do botão
        val btnEarly: Button = findViewById(R.id.btn_early)
        val btnAfternoon: Button = findViewById(R.id.btn_afternoon)

        btnEarly.setOnClickListener {
            val navegarPrimeiraTela = Intent(this, Menu::class.java)
            startActivity(navegarPrimeiraTela)
        }
        btnAfternoon.setOnClickListener {
            val navegarTeceiraTela = Intent(this, Menu3::class.java)
            startActivity(navegarTeceiraTela)
        }
    }
}