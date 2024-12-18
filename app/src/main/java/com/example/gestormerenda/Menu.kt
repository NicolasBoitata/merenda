package com.example.gestormerenda;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gestormerenda.adapter.FoodAdapter
import com.example.gestormerenda.model.Food
import com.google.firebase.firestore.FirebaseFirestore

class Menu : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val alimentos = mutableListOf<Food>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Inicializar RecyclerView e Adapter
        recyclerView = findViewById(R.id.recyclerViewAlimentos)
        adapter = FoodAdapter(alimentos)
        recyclerView.adapter = adapter

        // Configurar botões
        val btnMorning: Button = findViewById(R.id.btn_morning)
        val btnAfternoon: Button = findViewById(R.id.btn_afternoon)

        btnMorning.setOnClickListener {
            val navegarSegundaTela = Intent(this, Menu2::class.java)
            startActivity(navegarSegundaTela)
        }
        btnAfternoon.setOnClickListener {
            val navegarTerceiraTela = Intent(this, Menu3::class.java)
            startActivity(navegarTerceiraTela)
        }

        // Recuperar alimentos do Firestore
        db.collection("alimentos")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val food = document.toObject(Food::class.java)
                    alimentos.add(food)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Erro ao carregar alimentos: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}


//class Menu : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_menu)
//
//        // Usando findViewById para obter a referência do botão
//        val btnMorning: Button = findViewById(R.id.btn_morning)
//        val btnAfternoon: Button = findViewById(R.id.btn_afternoon)
//
//        btnMorning.setOnClickListener {
//            val navegarSegundaTela = Intent(this, Menu2::class.java)
//            startActivity(navegarSegundaTela)
//        }
//        btnAfternoon.setOnClickListener {
//            val navegarTerceiraTela = Intent(this, Menu3::class.java)
//            startActivity(navegarTerceiraTela)
//        }
//    }
//}















//    private lateinit var binding: MerendaTimetableToolbarBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = MerendaTimetableToolbarBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btn_morning.setOnClickListener {
//            val navegarSegundaTela = Intent(this, Menu2::class.java)
//            startActivity(navegarSegundaTela)
//        }
//    }
//}

//    private lateinit var binding: ActivityMenuBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = Activity MenuBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        setContentView(R.layout.activity_menu)
//
//        binding.btn_morning.setOnClickListener { it View!
//            val navegarSegundaTela = Intent(packageContext: this, Menu2::class.java)
//            startActivity (navegarSegundaTela)
//        }




//        val dropdownText: TextView = findViewById(R.id.dropdownText)
//        val dropdownContent: LinearLayout = findViewById(R.id.dropdownContent)
//
//        dropdownText.setOnClickListener {
//            if (dropdownContent.visibility == LinearLayout.GONE) {
//                dropdownContent.visibility = LinearLayout.VISIBLE
//            } else {
//                dropdownContent.visibility = LinearLayout.GONE
//            }
//        }


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