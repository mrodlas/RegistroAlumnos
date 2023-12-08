package com.example.registroalumnos.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumno")
data class Alumnos (
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    var nombre:String ="",
    val apellido:String = "",
    var curso:String = "",
)
