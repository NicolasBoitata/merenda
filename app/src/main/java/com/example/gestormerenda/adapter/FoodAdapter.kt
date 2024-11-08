package com.example.gestormerenda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gestormerenda.R
import com.example.gestormerenda.model.Food

class FoodAdapter(private val alimentos: List<Food>) : RecyclerView.Adapter<FoodAdapter.AlimentoViewHolder>() {

    class AlimentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAlimento: ImageView = itemView.findViewById(R.id.imgAlimento)
        val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alimento, parent, false)
        return AlimentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlimentoViewHolder, position: Int) {
        val alimento = alimentos[position]
        holder.txtTitulo.text = alimento.Title
        holder.txtDescricao.text = alimento.Description
        Glide.with(holder.itemView.context).load(alimento.imagemUri).into(holder.imgAlimento)
    }

    override fun getItemCount(): Int = alimentos.size
}



//package com.example.gestormerenda.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.gestormerenda.model.Food
//
//
//class FoodAdapter(private val alimentos: List<Food>) :
//    RecyclerView.Adapter<FoodAdapter.AlimentoViewHolder>() {
//
//    class AlimentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imgAlimento: ImageView = itemView.findViewById(R.id.imgAlimento)
//        val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
//        val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_alimento, parent, false)
//        return AlimentoViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: AlimentoViewHolder, position: Int) {
//        val alimento = alimentos[position]
//        holder.txtTitulo.text = alimento.Title
//        holder.txtDescricao.text = alimento.Description
//        Glide.with(holder.itemView.context).load(alimento.imagemUri).into(holder.imgAlimento)
//    }
//
//    override fun getItemCount(): Int = alimentos.size
//}





//package com.example.gestormerenda.adapter
//
//import android.app.AlertDialog
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.gestormerenda.Cadastro
//import com.example.gestormerenda.GestorAlimenticia
//import com.example.gestormerenda.databinding.ActivityCadastroBinding
//import com.example.gestormerenda.databinding.ActivityGestorAlimenticiaBinding
//import com.example.gestormerenda.model.Food
//
//class FoodAdapter (
//    private val context: Context,
//    private val deleteCallback: (Int) -> Unit
//) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
//
//    private var foods: List<Food> = emptyList()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
//        val binding = ActivityGestorAlimenticiaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return FoodViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
//        val food = foods[position]
//        holder.bind(food)
//
////        holder.binding.btnDeletar.setOnClickListener {
////            AlertDialog.Builder(holder.itemView.context)
////                .setTitle("Excluir Aluno")
////                .setMessage("Deseja realmente excluir o food ${food.nome}?")
////                .setPositiveButton("Sim") { _, _ ->
////                    deleteCallback(food.id)
////                }
////                .setNegativeButton("Não", null)
////                .show()
////        }
////
////        holder.binding.btnEditar.setOnClickListener {
////            val intent = Intent(context, GestorAlimenticia::class.java)
////            intent.putExtra("ALUNO_ID", food.id)
////            intent.putExtra("ALUNO_NOME", food.nome)
////            intent.putExtra("ALUNO_CPF", food.cpf)
////            intent.putExtra("ALUNO_EMAIL", food.email)
////            intent.putExtra("ALUNO_MATRICULA", food.matricula)
////            context.startActivity(intent)
////        }
//    }
//
//    override fun getItemCount(): Int {
//        return foods.size
//    }
//
//    fun setData(foods: List<Food>) {
//        this.foods = foods
//        notifyDataSetChanged()
//    }
//
//    inner class FoodViewHolder(val binding: ActivityGestorAlimenticiaBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(food: Food) {
//            binding.apply {
//                titleTextView.text = food.Title
////                cpfTextView.text = food.cpf
//                descriptionTextView.text = food.Description
////                matriculaTextView.text = food.matricula
//            }
//        }
//    }
//}
