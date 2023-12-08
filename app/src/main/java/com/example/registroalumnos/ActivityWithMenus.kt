package com.example.registroalumnos

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus : AppCompatActivity(){
    companion object{
        var activityActual = 0
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Relacionamos la clase con el layout del menú que hemos creado:
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_contextual, menu)

        //Desactivar la opción de la actividad en la que ya estamos:
        for(i in 0 until  menu.size()){
            if ( i== activityActual) menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.anadir -> {

                //Hacemos que se abra la pantalla del listado de parques:
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                activityActual = 0
                startActivity(intent)
                true
            }

            R.id.actualizar -> {

                //Hacemos que se abra la pantalla del formulario para añadir parques:
                val intent = Intent(this, UpdateActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                activityActual = 1
                startActivity(intent)
                true
            }

            R.id.eliminar -> {

                //Hacemos que se abra la pantalla del formulario para añadir parques:
                val intent = Intent(this, DeleteActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                activityActual = 2
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}