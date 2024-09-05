package com.example.gestormerenda;

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.LinearLayout
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val dropdownText: TextView = findViewById(R.id.dropdownText)
        val dropdownContent: LinearLayout = findViewById(R.id.dropdownContent)

        dropdownText.setOnClickListener {
            if (dropdownContent.visibility == LinearLayout.GONE) {
                dropdownContent.visibility = LinearLayout.VISIBLE
            } else {
                dropdownContent.visibility = LinearLayout.GONE
            }
        }
    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        //Testando a ação de clique
//        when(item.itemId){
//            R.id.menu_home -> {
//                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, Splash::class.java)
//                startActivity(intent)
//            }
//
//            R.id.menu_aluno -> {
//                Toast.makeText(this, "Alunos", Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, Inicial::class.java)
//                startActivity(intent)
//            }
//
//            R.id.menu_professor -> {
//                Toast.makeText(this, "Professores", Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, Login::class.java)
//                startActivity(intent)
//            }
//
//            R.id.menu_turma -> {
//                Toast.makeText(this, "Turmas", Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, gestorAlimenticia::class.java)
//                startActivity(intent)
//            }
//
//            R.id.menu_sair -> {
//                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, MainActivity::class.java)
//                startActivity(intent)
//            }
//
//            R.id.menu_adm -> {
//                Toast.makeText(this, "Administrador", Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, MainActivity2::class.java)
//                startActivity(intent)
//            }
//
//        }
//        return true
//    }

}