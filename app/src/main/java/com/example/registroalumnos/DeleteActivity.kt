package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registroalumnos.database.Alumnos
import com.example.registroalumnos.database.Instanciar
import com.example.registroalumnos.databinding.ActivityDeleteBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivityWithMenus() {
    lateinit var binding: ActivityDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bEliminar.setOnClickListener {
            delete(
                Alumnos(nombre= binding.tvNombreDelete.text.toString())
            )
        }
    }
    fun delete(alumnos: Alumnos){
        CoroutineScope(Dispatchers.IO).launch{
            val n = alumnos.nombre
            val recoveryalumno = Instanciar.database.alumnoDao().getAlumnoPorNombre(n)
            recoveryalumno.nombre= binding.tvNombreDelete.text.toString()
            Instanciar.database.alumnoDao().delete(recoveryalumno)
        }
    }
}