package com.example.gestormerenda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Inicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        val btnEntrando: Button = findViewById(R.id.btn_entrando)
        val btnCadastrando: Button = findViewById(R.id.btn_cadastrando)

        btnCadastrando.setOnClickListener {
            val navegarLogin = Intent(this, Cadastro::class.java)
            startActivity(navegarLogin)
        }
        btnEntrando.setOnClickListener {
            val navegarCadastro = Intent(this, Login::class.java)
            startActivity(navegarCadastro)
        }
    }
}