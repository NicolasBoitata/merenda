package com.example.gestormerenda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnEntrar: Button = findViewById(R.id.bt_entrar)

        btnEntrar.setOnClickListener {
            val navegarCardapio = Intent(this, Menu::class.java)
            startActivity(navegarCardapio)
        }
    }
}
