package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import com.example.registroalumnos.database.Alumnos
import com.example.registroalumnos.database.Instanciar
import com.example.registroalumnos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bAnadir.setOnClickListener {
            val nombre =binding.tvNombre.text.toString()
            val apellidos = binding.tvApellidos.text.toString()
            val curso = binding.tvCurso.text.toString()

            insert(Alumnos(nombre = nombre, apellido = apellidos, curso = curso))
        }

    }
    fun insert(alumnos: Alumnos){
        CoroutineScope(Dispatchers.IO).launch {
            Instanciar.database.alumnoDao().insert(alumnos)
        }
    }
}