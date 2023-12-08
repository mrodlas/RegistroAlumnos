package com.example.registroalumnos.database

import android.app.Application
import androidx.room.Room

class Instanciar:Application() {
    companion object{
        lateinit var  database :DBAlumno
    }

    override fun onCreate() {
        super.onCreate()
        Instanciar.database = Room.databaseBuilder(this, DBAlumno::class.java, "DBAlumno").build()
    }
}