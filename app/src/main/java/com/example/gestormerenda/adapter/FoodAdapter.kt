package com.example.gestormerenda.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestormerenda.Cadastro
import com.example.gestormerenda.GestorAlimenticia
import com.example.gestormerenda.databinding.ActivityCadastroBinding
import com.example.gestormerenda.databinding.ActivityGestorAlimenticiaBinding
import com.example.gestormerenda.model.Food

class FoodAdapter (
    private val context: Context,
    private val deleteCallback: (Int) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var foods: List<Food> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ActivityGestorAlimenticiaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)

//        holder.binding.btnDeletar.setOnClickListener {
//            AlertDialog.Builder(holder.itemView.context)
//                .setTitle("Excluir Aluno")
//                .setMessage("Deseja realmente excluir o food ${food.nome}?")
//                .setPositiveButton("Sim") { _, _ ->
//                    deleteCallback(food.id)
//                }
//                .setNegativeButton("Não", null)
//                .show()
//        }
//
//        holder.binding.btnEditar.setOnClickListener {
//            val intent = Intent(context, GestorAlimenticia::class.java)
//            intent.putExtra("ALUNO_ID", food.id)
//            intent.putExtra("ALUNO_NOME", food.nome)
//            intent.putExtra("ALUNO_CPF", food.cpf)
//            intent.putExtra("ALUNO_EMAIL", food.email)
//            intent.putExtra("ALUNO_MATRICULA", food.matricula)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun setData(foods: List<Food>) {
        this.foods = foods
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(val binding: ActivityGestorAlimenticiaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.apply {
                titleTextView.text = food.Title
//                cpfTextView.text = food.cpf
                descriptionTextView.text = food.Description
//                matriculaTextView.text = food.matricula
            }
        }
    }
}
