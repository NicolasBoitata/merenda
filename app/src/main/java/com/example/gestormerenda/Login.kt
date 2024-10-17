package com.example.gestormerenda

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailFields: EditText
    private lateinit var passwordFields: EditText
    private lateinit var btnLogin: Button
    private val mensagens = arrayOf("preencha todos os campos", "Login Efetuado com Sucesso")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        supportActionBar?.hide()
        iniciarComponentes()

        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val navegarCardapio = Intent(this, Menu::class.java)
            startActivity(navegarCardapio)
        }

        btnLogin.setOnClickListener { v ->
            val email = emailFields.text.toString()
            val password = passwordFields.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.WHITE)
                snackbar.setTextColor(Color.BLACK)
                snackbar.show()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            classifyUserByEmailDomain(email)
                        } else {
                            Toast.makeText(this, "Autenticação falhou.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun classifyUserByEmailDomain(email: String) {
        val domain = email.substringAfter("@")

        if (domain == "adm.com") {
            Toast.makeText(this, "Bem-vindo, Administração!", Toast.LENGTH_SHORT).show()
            val intent = Intent(
                applicationContext,
                GestorAlimenticia::class.java
            )
            startActivity(intent)
        } else {
            Toast.makeText(this, "Bem-vindo, Aluno!", Toast.LENGTH_SHORT).show()
            val intent = Intent(
                applicationContext,
                Menu::class.java
            )
            startActivity(intent)
        }
    }

    private fun iniciarComponentes() {
        emailFields = findViewById(R.id.emailFields)
        passwordFields = findViewById(R.id.passwordFields)
        btnLogin = findViewById(R.id.btnLogin)
    }
}
