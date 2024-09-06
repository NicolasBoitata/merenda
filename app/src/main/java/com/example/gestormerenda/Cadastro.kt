package com.example.gestormerenda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btnCadastrar: Button = findViewById(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {
            val navegarLogin = Intent(this, Login::class.java)
            startActivity(navegarLogin)
        }
    }
}