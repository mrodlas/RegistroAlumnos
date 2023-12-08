package com.example.registroalumnos.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlumnoDao {
    @Query("SELECT * FROM alumno WHERE nombre like:nombre")
    fun getAlumnoPorNombre(nombre:String) : Alumnos

    @Insert
    fun insert(alumnos: Alumnos)

    @Update
    fun update(alumnos: Alumnos)

    @Delete
    fun delete(alumnos: Alumnos)
}