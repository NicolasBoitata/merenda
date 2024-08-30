package com.example.gestormerenda

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.gestormerenda.databinding.ActivityGestorAlimenticiaBinding
import com.example.gestormerenda.databinding.AppendFoodBinding

class GestorAlimenticia : AppCompatActivity() {

        private var _binding: ActivityGestorAlimenticiaBinding? = null
        private val binding get() = _binding!!

        private val gestaoGaleria = registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->
            if (uri != null) {
                binding.imgPerfil.setImageURI(uri)
                Toast.makeText(this, "Imagem Selecionada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nenhuma Imagem Selecionada", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Inflando o layout usando ViewBinding
            _binding = ActivityGestorAlimenticiaBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Obtendo os dados da string array e configurando o AutoCompleteTextView
            val languages = resources.getStringArray(R.array.Horario)
            val arrayAdapter = ArrayAdapter(this, R.layout.list_item, languages)
            binding.autoCompleteTxt.setAdapter(arrayAdapter)

            // Configurando o botão para acessar a galeria
            acessarGaleria()
        }

        private fun acessarGaleria() {
            binding.btnAddGaleria.setOnClickListener {
                gestaoGaleria.launch("image/*")
            }
        }

        override fun onDestroy() {
            super.onDestroy()
            // Limpando o binding para evitar vazamento de memória
            _binding = null
        }
    }

//    private var _dropDownListView: ActivityGestorAlimenticiaBinding? = null
//    private val dropDownListView get() = _dropDownListView!!
//
//    private val binding by lazy {
//        ActivityGestorAlimenticiaBinding.inflate(layoutInflater)
//    }
//    private val gestaoGaleria = registerForActivityResult(
//        ActivityResultContracts.GetContent()
//    ){ uri ->
//        if ( uri != null){
//            binding.imgPerfil.setImageURI( uri )
//            Toast.makeText(this,
//                "Imagem Selecionada",
//                Toast.LENGTH_SHORT).show()
//        }else{
//            Toast.makeText(this,
//                "Nenhuma Imagem Selecionada",
//                Toast.LENGTH_SHORT).show()
//        }
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//        acessarGaleria()
//    }
//
//    private fun acessarGaleria() {
//        binding.btnAddGaleria.setOnClickListener {
//            gestaoGaleria.launch("image/*")
//        }
//    }
//}





//    private fun acessarGaleria() {
//        binding.btnAddGaleria.setOnClickListener {
//            gestaoGaleria.launch("image/*")
//        }
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_gestor_alimenticia)
//    }


//    private val binding by lazy {
//        AppendFoodBinding.inflate(layoutInflater)
//    }
//
//    private var bitmapImagemCamera: Bitmap? = null
//    private val gestaoGaleria = registerForActivityResult(
//        ActivityResultContracts.GetContent()
//    ) { uri ->
//        if (uri != null) {
//            binding.imgPerfil.setImageURI(uri)
//            Toast.makeText(this, "Imagem Selecionada", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Nenhuma Imagem Selecionada", Toast.LENGTH_SHORT).show()
//        }
//    }
//    private val gerenciaCamera = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { resultadoActivity ->
//        if (resultadoActivity.resultCode == RESULT_OK) {
//            bitmapImagemCamera = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                resultadoActivity.data?.extras?.getParcelable("data", Bitmap::class.java)
//            } else {
//                resultadoActivity.data?.extras?.getParcelable("data")
//            }
//            binding.imgPerfil.setImageBitmap(bitmapImagemCamera)
//        } else {
//            Toast.makeText(this, "Erro ao capturar imagem", Toast.LENGTH_SHORT).show()
//        }
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        // Check permissions
//        if (!hasPermissions()) {
//            requestPermissions()
//        }
//
//        binding.btnAddCamera.setOnClickListener {
//            if (hasCameraPermission()) {
//                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                gerenciaCamera.launch(intent)
//            } else {
//                Toast.makeText(this, "Permissão para câmera não concedida", Toast.LENGTH_SHORT).show()
//            }
//        }
//        acessarGaleria()
//    }
//
//    private fun acessarGaleria() {
//        binding.btnAddGaleria.setOnClickListener {
//            gestaoGaleria.launch("image/*")
//        }
//    }
//
//    private fun hasPermissions(): Boolean {
//        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//        val storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
//        return cameraPermission == PackageManager.PERMISSION_GRANTED &&
//                storagePermission == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun requestPermissions() {
//        ActivityCompat.requestPermissions(this, arrayOf(
//            Manifest.permission.CAMERA,
//            Manifest.permission.READ_EXTERNAL_STORAGE
//        ), PERMISSION_REQUEST_CODE)
//    }
//
//    private fun hasCameraPermission(): Boolean {
//        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
//    }
//
//    companion object {
//        private const val PERMISSION_REQUEST_CODE = 1
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted
//            } else {
//                Toast.makeText(this, "Permissões não concedidas", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}