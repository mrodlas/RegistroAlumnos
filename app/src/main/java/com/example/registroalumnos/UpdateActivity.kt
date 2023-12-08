package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import com.example.registroalumnos.database.Alumnos
import com.example.registroalumnos.database.Instanciar
import com.example.registroalumnos.databinding.ActivityMainBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : ActivityWithMenus() {
    lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bActualizar.setOnClickListener {
            update(Alumnos(nombre= binding.tvNombreUpdate.text.toString(),
                curso =binding.tvCursoUpdate.text.toString()))
        }
    }
    fun update(alumnos: Alumnos){
        CoroutineScope(Dispatchers.IO).launch{
            val n = alumnos.nombre
            val recoveryalumno = Instanciar.database.alumnoDao().getAlumnoPorNombre(n)
            recoveryalumno.curso= binding.tvCursoUpdate.text.toString()
            Instanciar.database.alumnoDao().update(recoveryalumno)
        }
    }
}