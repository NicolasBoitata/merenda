package com.example.gestormerenda;

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Snack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.merenda_timetable_toolbar)

//        val button: Button = findViewById(R.id.btn_early)


        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.button_snack)

//        button.setOnClickListener { view ->
//            view.startAnimation(animation)
//        }

        // Configurar o botão "Early"
        val btnEarly: Button = findViewById(R.id.btn_early)
        btnEarly.setOnClickListener { view ->
            view.startAnimation(animation)
            // Adicione a lógica adicional aqui
        }

        // Configurar o botão "Morning"
        val btnMorning: Button = findViewById(R.id.btn_morning)
        btnMorning.setOnClickListener { view ->
            view.startAnimation(animation)
            // Adicione a lógica adicional aqui
        }

        // Configurar o botão "Afternoon"
        val btnAfternoon: Button = findViewById(R.id.btn_afternoon)
        btnAfternoon.setOnClickListener { view ->
            view.startAnimation(animation)
            // Adicione a lógica adicional aqui
        }

    }
}